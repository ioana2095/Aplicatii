using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using WebApplication.DTO;
using WebApplication.Models;

namespace WebApplication.Controllers
{
    
    public class EditareController : Controller
    {
        //
        // GET: /Editare/
        
        public ActionResult Index()
        {
            return View();
        }
        
        public ActionResult Details(int UserId)
        {
            EditarePersoana model = new EditarePersoana();
            User U = new User();
            model = U.DetaliiPersoane(UserId);
            if (model == null)
            {
                return HttpNotFound();
            }
            return View(model);
        }

        public ActionResult DetailsCarte(int CarteId)
        {
            EditareCarte model = new EditareCarte();
            User U = new User();
            model = U.DetaliiCarte(CarteId);
            if (model == null)
            {
                return HttpNotFound();
            }
            return View(model);
        }
        public ActionResult DeleteCarte(int CarteId)
        {

            User U = new User();
            var user = U.DeleteCarte(CarteId);
            if (user != false)
            {
                return RedirectToAction("VizualizareCarti", "Vizualizare");
            }
            return View();
        }
        public ActionResult AddCarte()
        {
            return View();
        }

        [HttpPost]
        [AllowAnonymous]
        [ValidateAntiForgeryToken]
        public ActionResult AddCarte(EditareCarte model)
        {
            VizualizareController V = new VizualizareController();
            User U = new User();
            if (ModelState.IsValid)
            {
                bool user = U.AdugareCarte(model.Titlu, model.Nume, model.Prenume, model.Gen, model.Numar, model.Raft, model.Rand, model.Poz, model.identificare);
                if (user != false)
                {
                    return RedirectToAction("VizualizareCarti", "Vizualizare",new { Admin = 1 });
                }
            }
            return V.VizualizareAutori(); ;
        }
        public ActionResult Inchiriere()
        {
            return View();
        }
        [HttpPost]
        [AllowAnonymous]
        [ValidateAntiForgeryToken]
        public ActionResult Inchiriere(int CarteId,InchiriereCarte model)
        {
            VizualizareController V = new VizualizareController();
            User U = new User();
            if (ModelState.IsValid)
            {
                bool user = U.Inchiriere(model.Username, CarteId);
                if (user != false)
                {
                    return RedirectToAction("Inchiriere", "Editare");
                }
            }
            return V.VizualizareAutori();
        }
        public ActionResult Returnare(string username,string numecarte)
        {
            VizualizareController V = new VizualizareController();
            User U = new User();
            if (ModelState.IsValid)
            {
                bool user = U.Returnare(username, numecarte);
                if (user != false)
                {
                    return RedirectToAction("VizualizareCont", "Vizualizare",new { username = username });
                }
            }
            return V.VizualizareAutori();
        }
        public ActionResult Preinregistrare(int CarteId, Preinregistrare model)
        {
            VizualizareController V = new VizualizareController();
            User U = new User();
            if (ModelState.IsValid)
            {
                    bool user = U.Preinregistrare(model.Username, CarteId);
                    if (user != false)
                    {
                        return RedirectToAction("VizualizareCont", "Vizualizare", new { username = model.Username });
                    }
                
            }
            return V.VizualizareCont(model.Username);
        }
        public ActionResult Prelungire(string username, string numecarte)
        {
            VizualizareController V = new VizualizareController();
            User U = new User();
            if (ModelState.IsValid)
            {
                bool user = U.Prelungire(username, numecarte);
                if (user != false)
                {
                    return RedirectToAction("VizualizareCont", "Vizualizare", new { username = username });
                }
            }
            return V.VizualizareCont(username);
        }
    }
}