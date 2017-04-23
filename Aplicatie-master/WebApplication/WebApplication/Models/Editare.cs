using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;
using System.Web.UI;

namespace WebApplication.Models
{
    //acesata clasa este folosita pentru a crea modelul pentru interfata utilizator pentru vizualizarea detaliilor despre o carte
    public class EditarePersoana
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
    //acesata clasa este folosita pentru a crea modelul pentru interfata utilizator pentru a editat imformatii despre o carte
    public class EditareCarte
    {
        [Required]
        [Display(Name = "ID_Carte")]
        public int CarteId { get; set; }

        [Required]
        [Display(Name = "Titlu")]
        public string Titlu { get; set; }

        [Required]
        [Display(Name = "Autor Nume")]
        public string Nume { get; set; }

        [Required]
        [Display(Name = "Autor Prenume")]
        public string Prenume { get; set; }

        [Required]
        [Display(Name = "Gen")]
        public string Gen { get; set; }

        [Required]
        [Display(Name = "NumarExemplare")]
        public int Numar { get; set; }

        [Required]
        [Display(Name = "Raft")]
        public int Raft { get; set; }

        [Required]
        [Display(Name = "Rand")]
        public int Rand { get; set; }

        [Required]
        [Display(Name = "Pozitie")]
        public int Poz { get; set; }

        [Required]
        [Display(Name = "Identificare")]
        public float identificare { get; set; }
    }
    //acesata clasa este folosita ca si modelul pentru interfata utilizator pentru inchirierea unei carte 
    public class InchiriereCarte
    {
        [Required]
        [Display(Name = "ID_Carte")]
        public int CarteId { get; set; }

        [Required]
        [Display(Name = "Username")]
        public string Username { get; set; }

    }
    //acesata clasa este folosita ca si modelul pentru interfata utilizator pentru returnarea unei carte 
    public class ReturnareCarte
    {
        [Required]
        [Display(Name = "Titlu")]
        public int Titlu { get; set; }

        [Required]
        [Display(Name = "Username")]
        public string Username { get; set; }

    }
    //acesata clasa este folosita ca si modelul pentru interfata utilizator pentru preinregistrare unei carte 
    public class Preinregistrare
    {
        [Required]
        [Display(Name = "ID_Carte")]
        public int ID_Carte { get; set; }

        [Required]
        [Display(Name = "Titlu")]
        public string Titlu { get; set; }

        [Required]
        [Display(Name = "Username")]
        public string Username { get; set; }

    }
}