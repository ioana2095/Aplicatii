using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace WebApplication.Models
{
    //modelul pentru cum arata interfata utilizator pentru partea de vizualizare persoane
    public class VizualizarePersoane
    {
        [Required]
        [Display(Name = "ID_Persoana")]
        public int ID_Persoana { get; set; }

        [Required]
        [Display(Name = "Nume")]
        public string Nume { get; set; }

        [Required]
        [Display(Name = "Prenume")]
        public string Prenume { get; set; }

        [Required]
        [Display(Name = "Varsta")]
        public int Varsta { get; set; }

        [Required]
        [Display(Name = "ID_Abonament")]
        public int ID_Abonament { get; set; }

        [Required]
        [Display(Name = "Admin")]
        public int Admin { get; set; }

        [Required]
        [Display(Name = "Username")]
        public string Username { get; set; }


    }
    //modelul pentru cum arata interfata utilizator pentru partea de vizualizare autori
    public class VizualizareAutori
    {
        [Required]
        [Display(Name = "ID_Autor")]
        public int ID_Autor { get; set; }

        [Required]
        [Display(Name = "Nume")]
        public string Nume { get; set; }

        [Required]
        [Display(Name = "Prenume")]
        public string Prenume { get; set; }

    }
    //modelul pentru cum arata interfata utilizator pentru partea de vizualizarea cartilor din biblioteca
    public class VizualizareCarti
    {
        [Required]
        [Display(Name = "ID_Carte")]
        public int ID_Carte { get; set; }

        [Required]
        [Display(Name = "Titlu")]
        public string Titlu { get; set; }

        [Required]
        [Display(Name = "Nume")]
        public string Nume { get; set; }

        [Required]
        [Display(Name = "Gen")]
        public string Gen { get; set; }

        [Required]
        [Display(Name = "Nr_carti")]
        public string Numar { get; set; }

        [Required]
        [Display(Name = "Username")]
        public string Username { get; set; }

        [Required]
        [Display(Name = "Conditie")]
        public bool Conditie { get; set; }


    }
    //modelul pentru cum arata interfata utilizator pentru partea de vizualizare a exemplarelor dintr-o biblioteca
    public class VizualizareExemplare
    {
        [Required]
        [Display(Name = "Titlu")]
        public string Titlu { get; set; }

        [Required]
        [Display(Name = "Numar")]
        public int Numar { get; set; }
    }
    //modelul pentru cum arata interfata utilizator pentru partea de vizualizare a genurilor existente in biblioteca
    public class VizualizareGen
    {
        [Required]
        [Display(Name = "ID_Gen")]
        public int ID_Gen { get; set; }

        [Required]
        [Display(Name = "Gen")]
        public string Gen { get; set; }

    }
    //modelul pentru cum arata interfata utilizator pentru partea de top adica cele mai inchiriate carti
    public class VizualizareTop
    {
        [Required]
        [Display(Name = "Titlu")]
        public string Titlu { get; set; }

        [Required]
        [Display(Name = "Nr_carti")]
        public string Nr_carti { get; set; }

    }
    //modelul pentru cum arata interfata utilizator pentru partea de vizualizare a contului
    public class VizualizareCont
    {
        [Required]
        [Display(Name = "Username")]
        public string Username { get; set; }

        [Required]
        [Display(Name = "Nume")]
        public string Nume { get; set; }

        [Required]
        [Display(Name = "Prenume")]
        public string Prenume { get; set; }

        [Required]
        [Display(Name = "Varsta")]
        public string Varsta { get; set; }

        [Required]
        [Display(Name = "ID_Abonament")]
        public int ID_Abonament { get; set; }

        [Required]
        [Display(Name = "Admin")]
        public int Admin { get; set; }

        [Required]
        [Display(Name = "Data_Creare")]
        public string Data_Creare { get; set; }

        [Required]
        [Display(Name = "Data_Expirare")]
        public string Data_Expirare { get; set; }

        [Required]
        [Display(Name = "Data")]
        public string Data { get; set; }

        [Required]
        [Display(Name = "Titlu")]
        public List<string> Titlu { get; set; }

    }
    //modelul pentru cum arata interfata utilizator pentru partea de vizualizare a tuturor pozitiilor unei carti in biblioteca
    public class VizualizarePozitie
    {
        [Required]
        [Display(Name = "Titlu")]
        public string Titlu { get; set; }

        [Required]
        [Display(Name = "Raft")]
        public int Raft { get; set; }

        [Required]
        [Display(Name = "Rand")]
        public int Rand { get; set; }

        [Required]
        [Display(Name = "Poz")]
        public List<int> Poz { get; set; }

        [Required]
        [Display(Name = "Identificare")]
        public List<double> Identificare { get; set; }


    }
    //modelul pentru cum arata interfata utilizator pentru partea de vizualizarea a anunturilor
    //adica daca utilizatorul are abonamentul expirat si toate cartiile pentru care s-a preinregistrat
    public class VizualizareAnunturi
    {
        [Required]
        [Display(Name = "Data:")]
        public string Data { get; set; }

        [Required]
        [Display(Name = "Carte")]
        public string Titlu { get; set; }

        [Required]
        [Display(Name = "Nume")]
        public string Nume { get; set; }

        [Required]
        [Display(Name = "Gen")]
        public string Gen { get; set; }
    }
    

}