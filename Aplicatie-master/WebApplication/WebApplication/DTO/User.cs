using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Configuration;
using System.Data.SqlClient;
using System.Data;
using WebApplication.Models;


namespace WebApplication.DTO
{
    public class User
    {

        static string cale = System.Configuration.ConfigurationManager.ConnectionStrings["MyConnection"].ConnectionString;
        SqlConnection myCommand = new SqlConnection(cale);
        int n = 1,n1=1;
        int k;

        //functia pentru inregistrare
        public bool Introducere(string UserName, string FirstName, string LastName, string parola, int admin, int varsta)
        {

            //se calculeaza cate persoane se afla in baza de date in tabelul pentru logarea
            myCommand.Open();
            string queryS = "SELECT * FROM Logare";
            SqlCommand comend1 = new SqlCommand(queryS);
            comend1.Connection = myCommand;
            SqlDataReader reader;
            reader = comend1.ExecuteReader();
            while (reader.Read())
            {
                n++;
            }
            reader.Close();
            //se calculeaza cate persoane se afla in baza de date in tabelul pentru abonament
            string querySt = "SELECT * FROM Abonament";
            SqlCommand comend2 = new SqlCommand(querySt);
            comend2.Connection = myCommand;
            SqlDataReader reader1;
            reader1 = comend2.ExecuteReader();
            while (reader1.Read())
            {
                n1++;
            }
            reader1.Close();
            //se realizeaza inserarea datelor in baza de date in functie de calcule anterioare pentru determinarea id-ului si cu ajutorul datelor introduse de noul utilizator
            string queryStr = "Insert into Logare(ID_Persoana,UserName,[Pass_word]) values ('" + n + "','" + UserName + "','" + parola + "')" + "Insert into Abonament(ID_Abonament,Data_Creare,Data_Expirare)values ('" + n1 + "','" + DateTime.Now + "','" + DateTime.Today.Add(TimeSpan.FromDays(1825)) + "','" + "')" + "Insert into Persoana(ID_Persoana,Nume,Prenume,Varsta,ID_Abonament,Admin) values ('" + n + "','" + LastName + "','" + FirstName + "','" + varsta + "','" + n1 + "','" + admin + "')";
            SqlCommand comend = new SqlCommand(queryStr);
            comend.Connection = myCommand;
            comend.ExecuteNonQuery();
            if (queryStr != null)
                return true;
            return false;
        }

        //functia care realizeaza verificarea datelor care sunt introduse de la tastatura cu cele care sunt in baza de date
        public string Logare(string UserName, string parola)
        {
            string comanda = "SELECT Username,Pass_word,Admin FROM Logare,Persoana where Logare.ID_Persoana=Persoana.ID_Persoana";
            SqlCommand comm = new SqlCommand(comanda, myCommand);
            myCommand.Open();
            comm.Connection = myCommand;
            SqlDataReader reader;
            try
            {
                reader = comm.ExecuteReader();
                while (reader.Read())
                {
                    if (reader["UserName"].ToString().Equals(UserName) != false && reader["Pass_word"].ToString().Equals(parola) != false)
                    {
                        if (Convert.ToInt32(reader["Admin"]) == 1)
                            return "ADMIN";
                        else
                            return "USER";
                    }

                }
                reader.Close();

            }
            catch
            {

            }
            return null;
        }

        //este functia care face extragerea numelor carilor din baza de date pentru a se putea realiza vizualizarea acestora
        // se introduce o conditie pentru verificare daca utilizatorul este admin sau nu 
        public List<VizualizareCarti> Viz(int Admin)
        {
            List<string> list = new List<string>();
            string comanda = "SELECT Carte.ID_Carte,Titlu,Nume,Gen,Numar FROM Carte,Exemplare,Tip_Carte,Autor where Carte.ID_Carte=Exemplare.ID_Carte and Carte.ID_Gen=Tip_Carte.ID_Gen and Carte.ID_Autor=Autor.ID_Autor ";
            List<VizualizareCarti> lista = new List<VizualizareCarti>();
            SqlCommand comm = new SqlCommand(comanda, myCommand);
            myCommand.Open();
            comm.Connection = myCommand;
            int i = 0;
            using (var reader = comm.ExecuteReader())
            {
                if (Admin == 0)
                {
                    while (reader.Read())
                    {

                        lista.Insert(i, new VizualizareCarti
                        {
                            ID_Carte = Convert.ToInt32(reader["ID_Carte"]),
                            Titlu = reader["Titlu"].ToString(),
                            Nume = reader["Nume"].ToString(),
                            Gen = reader["Gen"].ToString(),
                            Numar = reader["Numar"].ToString(),
                            Conditie = false
                        });

                        i++;
                    }
                }
                else
                {
                    while (reader.Read())
                    {

                        lista.Insert(i, new VizualizareCarti
                        {
                            ID_Carte = Convert.ToInt32(reader["ID_Carte"]),
                            Titlu = reader["Titlu"].ToString(),
                            Nume = reader["Nume"].ToString(),
                            Gen = reader["Gen"].ToString(),
                            Numar = reader["Numar"].ToString(),
                            Conditie = true
                        });

                        i++;
                    }
                }

            }

            return lista;

        }
        public List<VizualizareCarti> VizualizareGen(string gen)
        {
            List<string> list = new List<string>();
            string comanda = "SELECT Carte.ID_Carte,Titlu,Nume,Gen,Numar FROM Carte,Exemplare,Tip_Carte,Autor where Carte.ID_Carte=Exemplare.ID_Carte and Carte.ID_Gen=Tip_Carte.ID_Gen and Carte.ID_Autor=Autor.ID_Autor ";
            List<VizualizareCarti> lista = new List<VizualizareCarti>();
            SqlCommand comm = new SqlCommand(comanda, myCommand);
            myCommand.Open();
            comm.Connection = myCommand;
            int i = 0;
            using (var reader = comm.ExecuteReader())
            {
                    while (reader.Read())
                    {
                    if (reader["Gen"].ToString().Equals(gen))
                    {
                        lista.Insert(i, new VizualizareCarti
                        {
                            ID_Carte = Convert.ToInt32(reader["ID_Carte"]),
                            Titlu = reader["Titlu"].ToString(),
                            Nume = reader["Nume"].ToString(),
                            Gen = reader["Gen"].ToString(),
                            Numar = reader["Numar"].ToString(),
                            Conditie = false
                        });
                        i++;
                    }
                        
                    }
                }

            
            return lista;

        }
        //este functia care face extragerea persoanelor din baza de date pentru a se putea realiza vizualizarea acestora
        // se introduce o conditie pentru verificare daca utilizatorul este admin sau nu deoarece acesatea vizualizare se poate realiza doar de administrator
        public List<VizualizarePersoane> VizulizarePersoane(int Admin)
        {
            List<string> list = new List<string>();
            string comanda = "SELECT * FROM Persoana,Logare where Persoana.ID_Persoana=Logare.ID_Persoana";
            List<VizualizarePersoane> lista = new List<VizualizarePersoane>();
            SqlCommand comm = new SqlCommand(comanda, myCommand);
            myCommand.Open();
            comm.Connection = myCommand;
            int i = 0;
            if (Admin == 1)
            {
                using (var reader = comm.ExecuteReader())
                {
                    while (reader.Read())
                    {
                        lista.Insert(i, new VizualizarePersoane
                        {
                            ID_Persoana= Convert.ToInt16(reader["ID_Persoana"]),
                            Nume = reader["Nume"].ToString(),
                            Prenume = reader["Prenume"].ToString(),
                            Varsta = Convert.ToInt16(reader["Varsta"]),
                            ID_Abonament = Convert.ToInt16(reader["ID_Abonament"]),
                            Admin = Convert.ToInt16(reader["Admin"]),
                            Username = reader["Username"].ToString()

                        });

                        i++;
                    }
                }
            }
            return lista;

        }

        //este functia care ofera detalii despre persoanele afisate in functie de id-ul selectat
        public EditarePersoana DetaliiPersoane(int Id)
        {
            string comanda = "SELECT * FROM Persoana,Logare";
            EditarePersoana lista = new EditarePersoana();
            SqlCommand comm = new SqlCommand(comanda, myCommand);
            myCommand.Open();
            comm.Connection = myCommand;
            int i = 0;
                using (var reader = comm.ExecuteReader())
                {
                    while (reader.Read())
                    {
                        if(Convert.ToInt16(reader["ID_Persoana"])==Id)
                        return new EditarePersoana
                        {
                            ID_Persoana = Convert.ToInt16(reader["ID_Persoana"]),
                            Nume = reader["Nume"].ToString(),
                            Prenume = reader["Prenume"].ToString(),
                            Varsta = Convert.ToInt16(reader["Varsta"]),
                            ID_Abonament = Convert.ToInt16(reader["ID_Abonament"]),
                            Admin = Convert.ToInt16(reader["Admin"]),
                            Username = reader["Username"].ToString()

                        };
                    }
                }
            return null;

        }
        //este functia care face extragerea autori din baza de date pentru a se putea realiza vizualizarea acestora
         public List<VizualizareAutori> VizulizareA()
        {
            List<string> list = new List<string>();
            string comanda = "SELECT * FROM Autor";
            List<VizualizareAutori> lista = new List<VizualizareAutori>();
            SqlCommand comm = new SqlCommand(comanda, myCommand);
            myCommand.Open();
            comm.Connection = myCommand;
            int i = 0;
            using (var reader = comm.ExecuteReader())
            {
                while (reader.Read())
                {
                    lista.Insert(i, new VizualizareAutori
                    {
                        ID_Autor = Convert.ToInt32(reader["ID_Autor"]),
                        Nume = reader["Nume"].ToString(),
                        Prenume = reader["Prenume"].ToString()
                    });

                    i++;
                }
            }

            return lista;

        }

        //in acesata functie se face vizualizarea anunturilor in functie de username adica se afiseaza pentru un anumit user daca abonamentul
        //este expirat sau nu si daca acesata are cartii pentru care s-a preinregistrat si vrea sa stie daca sunt disponibile
       public List<VizualizareAnunturi> VizualizareAnunt(string username)
        {
            myCommand.Open();
            string com = "SELECT Username,Data_Expirare from Abonament,Persoana,Logare  where  Persoana.ID_Persoana=Logare.ID_Persoana and Abonament.ID_Abonament=Persoana.ID_Abonament";
            int x = 0;
            SqlCommand sqlcom = new SqlCommand(com, myCommand);
            sqlcom.Connection = myCommand;
            using (var reader1 = sqlcom.ExecuteReader())
            {
                while (reader1.Read())
                {
                    if (reader1["Username"].ToString().Equals(username))
                    {
                        if (Convert.ToDateTime(reader1["Data_Expirare"]) < DateTime.Now)
                        {
                            x = 1;
                        }
                    }
                }
            }

            List<string> list = new List<string>();
            string comanda = "SELECT Titlu,Autor.Nume,Gen,Username from Abonament,Persoana,Logare,Carte,Tip_Carte,Autor,Preinregistrare where Abonament.ID_Abonament=Preinregistrare.ID_Abonament and Persoana.ID_Persoana=Logare.ID_Persoana and  Abonament.ID_Abonament=Persoana.ID_Abonament and Preinregistrare.ID_Carte=Carte.ID_Carte and Carte.ID_Gen=Tip_Carte.ID_Gen and Carte.ID_Autor=Autor.ID_Autor  ";
            List<VizualizareAnunturi> lista = new List<VizualizareAnunturi>();
            SqlCommand comm = new SqlCommand(comanda, myCommand);
            int k = 0;
            comm.Connection = myCommand;
            using (var reader = comm.ExecuteReader())
            {
                while (reader.Read())
                {
                    if (x == 0)
                    {
                        if (reader["Username"].ToString().Equals(username)) {
                        
                                lista.Insert(k, new VizualizareAnunturi
                                {
                                    Titlu = reader["Titlu"].ToString(),
                                    Nume = reader["Nume"].ToString(),
                                    Gen = reader["Gen"].ToString()
                                });
                            }
                            else
                            {
                                lista.Insert(k, new VizualizareAnunturi
                                {
                                    Titlu = null,
                                    Nume = null,
                                    Gen = null
                                });
                            }
                        }
                        else
                        {
                            if (reader["Username"].ToString().Equals(username))
                            {

                                lista.Insert(k, new VizualizareAnunturi
                                {
                                    Data = "Abonament expirat",
                                    Titlu = reader["Titlu"].ToString(),
                                    Nume = reader["Nume"].ToString(),
                                    Gen = reader["Gen"].ToString()
                                });
                            }
                            else
                            {
                                lista.Insert(k, new VizualizareAnunturi
                                {
                                    Data = "Abonament expirat",
                                    Titlu = null,
                                    Nume = null,
                                    Gen = null
                                });
                            }
                        }
                    }
            }

            return lista;
        } 
        //functia acesata face extragerea din baza de date a tututror genurilor care se afla in baza de date
        public List<VizualizareGen> VizulizareG()
        {
            List<string> list = new List<string>();
            string comanda = "SELECT * FROM Tip_Carte";
            List<VizualizareGen> lista = new List<VizualizareGen>();
            SqlCommand comm = new SqlCommand(comanda, myCommand);
            myCommand.Open();
            comm.Connection = myCommand;
            int i = 0;
            using (var reader = comm.ExecuteReader())
            {
                while (reader.Read())
                {
                    lista.Insert(i, new VizualizareGen
                    {
                        ID_Gen = Convert.ToInt32(reader["ID_Gen"]),
                        Gen = reader["Gen"].ToString()
                    });

                    i++;
                }
            }

            return lista;

        }
        //se realizeaza un top al celor mai imprumutate carti in functie de cati au imprumutat cartea respectiva
        public List<VizualizareTop> VizulizareT()
        {
            List<string> list = new List<string>();
            string comanda = "SELECT Titlu ,Nr_carti FROM Carte ORDER BY Nr_carti Desc";
            List<VizualizareTop> lista = new List<VizualizareTop>();
            SqlCommand comm = new SqlCommand(comanda, myCommand);
            myCommand.Open();
            comm.Connection = myCommand;
            int i = 0;
            using (var reader = comm.ExecuteReader())
            {
                while (reader.Read())
                {
                    lista.Insert(i, new VizualizareTop
                    {
                        Titlu = reader["Titlu"].ToString(),
                        Nr_carti = reader["Nr_carti"].ToString()
                    });

                    i++;
                }
            }

            return lista;

        }

        //se face o extragere a datelor care reprezinta pozitia pe care se afla o anumita carte impreuna cu codul de identificare,raft si rand
        public VizualizarePozitie VizulizareP(int idCarte)
        {
            List<int> list = new List<int>();
            string comanda = "SELECT ID_Carte,Poz FROM Pozitie";
            SqlCommand comm = new SqlCommand(comanda, myCommand);
            myCommand.Open();
            comm.Connection = myCommand;
            using (var reader = comm.ExecuteReader())
            {
                while (reader.Read())
                {
                    if (Convert.ToInt16(reader["ID_Carte"]) == idCarte)
                        list.Add(Convert.ToInt16(reader["Poz"]));
                }
            }
            List<double> list2 = new List<double>();
            string comanda2 = "SELECT ID_Carte,identificare FROM Pozitie";
            SqlCommand comm2 = new SqlCommand(comanda2, myCommand);
            comm2.Connection = myCommand;
            using (var reader2 = comm2.ExecuteReader())
            {
                while (reader2.Read())
                {
                    if (Convert.ToInt16(reader2["ID_Carte"]) == idCarte)
                        list2.Add(Convert.ToDouble(reader2["identificare"]));
                }
            }
            string comanda3 = "SELECT Carte.ID_Carte,Titlu ,Raft,Rand,Poz,identificare From Carte,Pozitie where Carte.ID_Carte=Pozitie.ID_Carte";
            List<VizualizarePozitie> lista = new List<VizualizarePozitie>();
            SqlCommand comm3 = new SqlCommand(comanda3, myCommand);
            comm3.Connection = myCommand;
            int i = 0;
            using (var reader3 = comm3.ExecuteReader())
            {
                while (reader3.Read())
                {
                    if (Convert.ToInt16(reader3["ID_Carte"]) == idCarte)
                    {
                        return new VizualizarePozitie
                        {
                            Titlu = reader3["Titlu"].ToString(),
                            Raft = Convert.ToInt16(reader3["Raft"]),
                            Rand = Convert.ToInt16(reader3["Rand"]),
                            Poz = list,
                            Identificare = list2
                        };
                    }
                }
            }
            return null;
        }

        //se face o extragere  a datelor despre carti si  numarul de exemplare disponibile 
        public List<VizualizareExemplare> VizulizareE()
        {
            List<string> list = new List<string>();
            string comanda = "SELECT Titlu , Numar FROM Carte,Exemplare where Carte.ID_Carte=Exemplare.ID_Carte;";
            List<VizualizareExemplare> lista = new List<VizualizareExemplare>();
            SqlCommand comm = new SqlCommand(comanda, myCommand);
            myCommand.Open();
            comm.Connection = myCommand;
            int i = 0;
            using (var reader = comm.ExecuteReader())
            {
                while (reader.Read())
                {
                    lista.Insert(i, new VizualizareExemplare
                    {
                        Titlu = reader["Titlu"].ToString(),
                        Numar = Convert.ToInt32(reader["Numar"])
                    });

                    i++;
                }
            }

            return lista;

        }
        int j;
        bool contor;

        // functia care extrage toate datele despre o persoana anume din baza de date
        public VizualizareCont VizualizareC(string username)
        {
            List<string> list = new List<string>();
            List<string> list1 = new List<string>();
            List<string> listaFin = new List<string>();
            string querry = "SELECT Titlu,Username,Abonament.ID_Abonament,Nume,Data FROM Carte,Abonament,Persoana,Logare,Imprumut where Carte.ID_Carte=Imprumut.ID_Carte AND Imprumut.ID_Abonament=Abonament.ID_Abonament and Abonament.ID_Abonament=Persoana.ID_Abonament and Persoana.ID_Persoana=Logare.ID_Persoana";
            SqlCommand comand = new SqlCommand(querry, myCommand);
            myCommand.Open();
            comand.Connection = myCommand;
            using (var reader1 = comand.ExecuteReader())
            {
                while (reader1.Read())
                {
                    if (reader1["Username"].ToString().Equals(username))
                    {
                        list.Add(reader1["Titlu"].ToString());
                    }
                }
            }
            string comanda = "SELECT Username,Nume,Prenume,Varsta,Abonament.ID_Abonament,Admin,Data_Creare,Data_Expirare,Data,Titlu,Username FROM Persoana,Abonament,Imprumut,Carte,Logare where Persoana.ID_Abonament=Abonament.ID_Abonament and Abonament.ID_Abonament=Imprumut.ID_Abonament and Imprumut.ID_Carte=Carte.ID_Carte and Persoana.ID_Persoana=Logare.ID_Persoana";
            List<VizualizareCont> lista = new List<VizualizareCont>();
            SqlCommand comm = new SqlCommand(comanda, myCommand);
            //myCommand.Open();
            comm.Connection = myCommand;
            int i = 0;
            using (var reader = comm.ExecuteReader())
            {
                while (reader.Read())
                {
                    if (reader["Username"].ToString().Equals(username))
                    {
                        return new VizualizareCont
                        {
                            Username = reader["Username"].ToString(),
                            Nume = reader["Nume"].ToString(),
                            Prenume = reader["Prenume"].ToString(),
                            Varsta = reader["Varsta"].ToString(),
                            ID_Abonament = Convert.ToInt32(reader["ID_Abonament"]),
                            Admin = Convert.ToInt32(reader["Admin"]),
                            Data_Creare = reader["Data_Creare"].ToString(),
                            Data_Expirare = reader["Data_Expirare"].ToString(),
                            Data = reader["Data"].ToString(),
                            Titlu = list
                        };
                    }
                }
            }

            return null;

        }
        //extrage din baza de date informatii despre o carte anume 
        public EditareCarte DetaliiCarte(Int32 UserId)
        {
            string comanda = "SELECT ID_Carte,Titlu,Nume,Prenume,Gen FROM Carte,Autor,Tip_Carte where Carte.ID_Gen=Tip_Carte.ID_Gen and Carte.ID_Autor=Autor.ID_Autor ";
            SqlCommand comm = new SqlCommand(comanda, myCommand);
            myCommand.Open();
            comm.Connection = myCommand;
            SqlDataReader reader;
            reader = comm.ExecuteReader();
            while (reader.Read())
            {
                if (Convert.ToInt32(reader["ID_Carte"]) == UserId)
                    return new EditareCarte
                    {
                        Titlu = reader["Titlu"].ToString(),
                        Nume = reader["Nume"].ToString(),
                        Prenume = reader["Prenume"].ToString(),
                        Gen = reader["Gen"].ToString()
                    };
            }
            return null;

        }
        //este o functie care sterge din baza de date o carte specificata prin id
        public bool DeleteCarte(int CarteId)
        {
            myCommand.Open();
            string queryStr = "Delete From Carte where ID_Carte='" + CarteId + "'";
            SqlCommand comend = new SqlCommand(queryStr);
            comend.Connection = myCommand;
            comend.ExecuteNonQuery();
            if (queryStr != null)
                return true;
            return false;
        }
        //este functia care aduga o carte nou in baza de date acest tip de introducere de date se poate realiza doar de administrator
        int nr;
        public bool AdugareCarte(string Titlu, string Nume, string Prenume, string Gen, int Numar, int Raft, int Rand, int Poz, float identificare)
        {

            myCommand.Open();
            string query = "SELECT Titlu,Nume,Prenume,Gen FROM Carte,Autor,Tip_Carte where Carte.ID_Gen=Tip_Carte.ID_Gen and Carte.ID_Autor=Autor.ID_Autor ";
            SqlCommand comm = new SqlCommand(query, myCommand);
            comm.Connection = myCommand;
            SqlDataReader reader;
            reader = comm.ExecuteReader();
            while (reader.Read())
            {
                if (reader["Titlu"].ToString().Equals(Titlu) == true)
                {
                    if (reader["Nume"].ToString().Equals(Nume) == true && reader["Prenume"].ToString().Equals(Prenume) == true)
                    {
                        if (reader["Gen"].ToString().Equals(Gen) == true)
                        {
                            return true;
                        }
                    }
                }
                else
                {
                    if (reader["Nume"].ToString().Equals(Nume) == true && reader["Prenume"].ToString().Equals(Prenume) == true && reader["Gen"].ToString().Equals(Gen) == true)
                    {
                        reader.Close();
                        string queryS = "SELECT * FROM Autor";
                        SqlCommand comend1 = new SqlCommand(queryS);
                        comend1.Connection = myCommand;
                        SqlDataReader reader1;
                        reader1 = comend1.ExecuteReader();
                        while (reader1.Read())
                        {
                            if(reader1["Nume"].ToString().Equals(Nume) && reader1["Prenume"].ToString().Equals(Prenume))
                                n = Convert.ToInt32(reader1["ID_Autor"]);
                        }
                        reader1.Close();
                        string query1 = "SELECT * FROM Tip_Carte";
                        SqlCommand comend = new SqlCommand(query1);
                        comend.Connection = myCommand;
                        SqlDataReader reader2;
                        reader2 = comend.ExecuteReader();
                        while (reader2.Read())
                        {
                            if (reader2["Gen"].ToString().Equals(Gen))
                                k = Convert.ToInt32(reader2["ID_Gen"]);

                        }
                        reader2.Close();
                        string queryst = "SELECT * FROM Carte";
                        SqlCommand comend2 = new SqlCommand(queryst);
                        comend2.Connection = myCommand;
                        SqlDataReader reader3;
                        reader3 = comend2.ExecuteReader();
                        while (reader3.Read())
                        {
                            nr++;
                        }
                        reader3.Close();
                        int aux = nr++;
                        string queryStr = "Insert into Carte(ID_Carte,Titlu,ID_Autor,ID_Gen) values ('" + nr++ + "','" + Titlu + "','" + n + "','" + k + "')" + "Insert into Exemplare(Numar,ID_Carte) values('" + Numar + "', '" + nr++ + "')"+"Insert into Exemplare(Numar,ID_Carte) values ('" + Numar + "','" + aux + "')";
                        string str=null;
                        SqlCommand comend3 = new SqlCommand(queryStr);
                        comend3.Connection = myCommand;
                        comend3.ExecuteNonQuery();
                        for (int z=0;z<Numar; z++)
                        {
                            str= "Insert into Pozitie(ID_Carte,Raft,Rand,Poz,identificare) values('" + aux + "', '" + Raft + "', '" + Rand + "', '" + Poz++ + "', '" + identificare++ + "')";
                            SqlCommand comend4 = new SqlCommand(str);
                            comend4.Connection = myCommand;
                            comend4.ExecuteNonQuery();
                        }
                        
                        if (queryStr != null && str!=null)
                            return true;
                        return false;
                    }
                    else
                    {
                        reader.Close();
                        string queryS = "SELECT * FROM Autor";
                        SqlCommand comend1 = new SqlCommand(queryS);
                        comend1.Connection = myCommand;
                        SqlDataReader reader1;
                        reader1 = comend1.ExecuteReader();
                        while (reader1.Read())
                        {
                            n++;
                        }
                        reader1.Close();
                        string query1 = "SELECT * FROM Tip_Carte";
                        SqlCommand comend = new SqlCommand(query1);
                        comend.Connection = myCommand;
                        SqlDataReader reader2;
                        reader2 = comend.ExecuteReader();
                        while (reader2.Read())
                        {
                            if (reader2["Gen"].ToString().Equals(Gen))
                                k = Convert.ToInt32(reader2["ID_Gen"]);
                                
                        }
                        reader2.Close();
                        string queryst = "SELECT * FROM Carte";
                        SqlCommand comend2 = new SqlCommand(queryst);
                        comend2.Connection = myCommand;
                        SqlDataReader reader3;
                        reader3 = comend2.ExecuteReader();
                        while (reader3.Read())
                        {
                            nr++;
                        }
                        reader3.Close();
                        int aux = nr +1;
                        string queryStr = "Insert into Autor(ID_Autor,Nume,Prenume)values ('" + n ++ + "','" + Nume + "','" + Prenume + "')" + "Insert into Carte(ID_Carte,Titlu,ID_Autor,ID_Gen) values ('" + aux + "','" + Titlu + "','" +  n++ + "','" + k + "')" + "Insert into Exemplare(Numar,ID_Carte) values ('" + Numar + "','" + aux + "')";
                        string str = null;
                        SqlCommand comend3 = new SqlCommand(queryStr);
                        comend3.Connection = myCommand;
                        comend3.ExecuteNonQuery();
                        for (int z = 0; z < Numar; z++)
                        {
                            str = "Insert into Pozitie(ID_Carte,Raft,Rand,Poz,identificare) values('" + aux + "', '" + Raft + "', '" + Rand + "', '" + Poz++ + "', '" + identificare++ + "')";
                            SqlCommand comend4 = new SqlCommand(str);
                            comend4.Connection = myCommand;
                            comend4.ExecuteNonQuery();
                        }
                        if (queryStr != null && str!=null)
                            return true;
                        return false;
                    }

                }

            }
            return false;
        }
        //acesata functie face mofificari in baza de date mai exact schimba pentru o anumita carte si un anumit utilizator datele adica 
        // se intrduc date in baza de date care determina inchirierea carti adica se scade din exemplare numarul se pune in inchiriere date 
        //despre carte si utilizator
        int id,val;
        public bool Inchiriere(string username,int idCarte)
        {
            
            myCommand.Open();
            string str = "Select Abonament.ID_Abonament,Persoana.ID_Persoana,Username from Abonament,Persoana,Logare where Abonament.ID_Abonament=Persoana.ID_Abonament and Persoana.ID_Persoana=Logare.ID_Persoana";
            SqlCommand comend = new SqlCommand(str);
            comend.Connection = myCommand;
            SqlDataReader reader1;
            reader1 = comend.ExecuteReader();
            while (reader1.Read())
            {
                if (reader1["Username"].ToString().Equals(username))
                    id = Convert.ToInt16(reader1["ID_Abonament"]);
            }
            reader1.Close();
            string str2 = "Select * from Exemplare";
            SqlCommand comend2 = new SqlCommand(str2);
            comend2.Connection = myCommand;
            SqlDataReader reader3;
            reader3 = comend2.ExecuteReader();
            while (reader3.Read())
            {
                if (Convert.ToInt16(reader3["ID_Carte"]) == idCarte)
                    val = Convert.ToInt16(reader3["Numar"]);


            }
            reader3.Close();
            
            string querry = "Insert into Imprumut(Data,ID_Carte,ID_Abonament) values ('" + DateTime.Now.ToShortDateString() + "','" + idCarte + "','" + id + "')"+ "Insert into Returnare(Data,ID_Carte,ID_Abonament) values ('" + DateTime.Today.Add(TimeSpan.FromDays(10)) + "','" + idCarte + "','" + id + "')";
            SqlCommand comend1 = new SqlCommand(querry);
            comend1.Connection = myCommand;
            comend1.ExecuteNonQuery();
            SqlCommand come = myCommand.CreateCommand();
            come.CommandText = "UPDATE Exemplare SET Numar=@dt where ID_Carte=@ic";
            come.Parameters.AddWithValue("@dt", val - 1);
            come.Parameters.AddWithValue("@ic", id);
            come.Connection = myCommand;
            come.ExecuteNonQuery();
            if (querry != null && come.CommandText != null)
                return true;
            return false;
        }
        //aceasta functie face modificari in baza de date adica se modfifica toate datele necesare pentru a returna o carte adica 
        //este nevoie sa se stie care carte a fost returnata si de catre cine
        int id2;
        public bool Returnare(string UserName,string numeCarte)
        {
            myCommand.Open();
            string str = "Select Abonament.ID_Abonament,Persoana.ID_Persoana,Username from Abonament,Persoana,Logare where Abonament.ID_Abonament=Persoana.ID_Abonament and Persoana.ID_Persoana=Logare.ID_Persoana";
            SqlCommand comend = new SqlCommand(str);
            comend.Connection = myCommand;
            SqlDataReader reader1;
            reader1 = comend.ExecuteReader();
            while (reader1.Read())
            {
                if (reader1["Username"].ToString().Equals(UserName))
                    id = Convert.ToInt16(reader1["ID_Abonament"]);
            }
            reader1.Close();
            string str1 = "Select Titlu,ID_Carte from Carte";
            SqlCommand comend1 = new SqlCommand(str1);
            comend1.Connection = myCommand;
            SqlDataReader reader2;
            reader2 = comend1.ExecuteReader();
            while (reader2.Read())
            {
                if (reader2["Titlu"].ToString().Equals(numeCarte))
                    id2 = Convert.ToInt16(reader2["ID_Carte"]);
            }
            reader2.Close();
            string str2 = "Select * from Exemplare";
            SqlCommand comend2 = new SqlCommand(str2);
            comend2.Connection = myCommand;
            SqlDataReader reader3;
            reader3 = comend2.ExecuteReader();
            while (reader3.Read())
            {
                if (Convert.ToInt16(reader3["ID_Carte"]) == id2)
                    val = Convert.ToInt16(reader3["ID_Carte"]);


            }
            reader3.Close();
            string str3 = "Delete From Imprumut where ID_Abonament='" + id + "'  and ID_Carte='" + id2 + "'";
            SqlCommand comend3 = new SqlCommand(str3);
            comend3.Connection = myCommand;
            comend3.ExecuteNonQuery();
            SqlCommand come = myCommand.CreateCommand();
            come.CommandText = "UPDATE Exemplare SET Numar=@dt where ID_Carte=@ic";
            come.Parameters.AddWithValue("@dt", val+1);
            come.Parameters.AddWithValue("@ic", id);
            come.Connection = myCommand;
            come.ExecuteNonQuery();
            if ( str3!=null && come.CommandText != null)
                return true;
            return false;
        }
        // se introduce in baza de date o prelungire pentru o anumita carte adica numarul curent se creste cu 10 zile in plus
        public bool Prelungire(string UserName, string numeCarte)
        {
            myCommand.Open();
            string str = "Select Abonament.ID_Abonament,Persoana.ID_Persoana,Username from Abonament,Persoana,Logare where Abonament.ID_Abonament=Persoana.ID_Abonament and Persoana.ID_Persoana=Logare.ID_Persoana";
            SqlCommand comend = new SqlCommand(str);
            comend.Connection = myCommand;
            SqlDataReader reader1;
            reader1 = comend.ExecuteReader();
            while (reader1.Read())
            {
                if (reader1["Username"].ToString().Equals(UserName))
                    id = Convert.ToInt16(reader1["ID_Abonament"]);
            }
            reader1.Close();
            string str1 = "Select Titlu,ID_Carte from Carte";
            SqlCommand comend1 = new SqlCommand(str1);
            comend1.Connection = myCommand;
            SqlDataReader reader2;
            reader2 = comend1.ExecuteReader();
            while (reader2.Read())
            {
                if (reader2["Titlu"].ToString().Equals(numeCarte))
                    id2 = Convert.ToInt16(reader2["ID_Carte"]);
            }
            reader2.Close();
            SqlCommand comend2 = myCommand.CreateCommand();
            comend.CommandText = "UPDATE Returnare SET Data=@dt where ID_Carte=@ic and ID_Abonament=@ia";
            comend.Parameters.AddWithValue("@dt", DateTime.Today.Add(TimeSpan.FromDays(10)));
            comend.Parameters.AddWithValue("@ic", id);
            comend.Parameters.AddWithValue("@ia", id2);
            comend.Connection = myCommand;
            comend.ExecuteNonQuery();
            if (comend.CommandText != null)
                return true;
            return false;
        }
        //o persoana se poate preinregistra pentru o carte daca acesata nu este diponibila sau daca vrea doar sa fie sigur ca poate sa o 
        //imprumute intr-un viitor apropiat
        public bool Preinregistrare(string username, int idCarte)
        {
            int numar = 0;
            string s = null ;
            myCommand.Open();
            string str = "Select Abonament.ID_Abonament,Persoana.ID_Persoana,Username from Abonament,Persoana,Logare where Abonament.ID_Abonament=Persoana.ID_Abonament and Persoana.ID_Persoana=Logare.ID_Persoana";
            SqlCommand comend = new SqlCommand(str);
            comend.Connection = myCommand;
            SqlDataReader reader1;
            reader1 = comend.ExecuteReader();
            while (reader1.Read())
            {
                if (reader1["Username"].ToString().Equals(username))
                    id = Convert.ToInt16(reader1["ID_Abonament"]);
            }
            reader1.Close();
            string str3 = "Select * from Preinregistrare";
            SqlCommand comend3 = new SqlCommand(str3);
            comend3.Connection = myCommand;
            SqlDataReader reader4;
            reader4 = comend3.ExecuteReader();
            while (reader4.Read())
            {

                numar++;

            }
            reader4.Close();

            numar = numar + 1;
            string querry = "Insert into Preinregistrare(ID_Preinregistrare,ID_Abonament,ID_Carte) values ('" + numar + "','" + id + "','" + idCarte + "')";
            SqlCommand comend2 = new SqlCommand(querry);
            comend2.Connection = myCommand;
            comend2.ExecuteNonQuery();
            if (querry != null)
                return true;
            return false;
        }
    }
}