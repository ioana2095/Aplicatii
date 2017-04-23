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
    public class VizualizareController : Controller
    {
        // GET: Vizualizare
        public ActionResult Index()
        {
            return View();
        }
        public ActionResult VizualizareCarti(int Admin)
        {
            List<VizualizareCarti> model = new List<VizualizareCarti>();
            User U = new User();
            model = U.Viz(Admin);
            return View(model);
        }
        public ActionResult VizualizareCartiGen(string Gen)
        {
            List<VizualizareCarti> model = new List<VizualizareCarti>();
            User U = new User();
            model = U.VizualizareGen(Gen);
            return View(model);
    
        }
        public ActionResult VizualizareAutori()
        {
            List<VizualizareAutori> model = new List<VizualizareAutori>();
            User U = new User();
            model = U.VizulizareA();
            return View(model);
        }
        public ActionResult VizualizareGen()
        {
            List<VizualizareGen> model = new List<VizualizareGen>();
            User U = new User();
            model = U.VizulizareG();
            return View(model);
        }
        public ActionResult VizualizareTop()
        {
            List<VizualizareTop> model = new List<VizualizareTop>();
            User U = new User();
            model = U.VizulizareT();
            return View(model);
        }
        public ActionResult VizualizareExemplare()
        {
            List<VizualizareExemplare> model = new List<VizualizareExemplare>();
            User U = new User();
            model = U.VizulizareE();
            return View(model);
        }
        public ActionResult VizualizareCont(string username)
        {
            VizualizareCont model = new VizualizareCont();
            User U = new User();
            model = U.VizualizareC(username);
            return View(model);
        }

        public ActionResult VizualizarePozitie(int CarteId)
        {
            VizualizarePozitie model = new VizualizarePozitie();
            User U = new User();
            model = U.VizulizareP(CarteId);
            return View(model);
        }
        public ActionResult VizualizareAnunturi(string username)
        {
            List<VizualizareAnunturi> model = new List<VizualizareAnunturi>();
            User U = new User();
            model = U.VizualizareAnunt(username);
            return View(model);
        }
        public ActionResult VizualizarePersoane(int Admin)
        {
            List<VizualizarePersoane> model = new List<VizualizarePersoane>();
            User U = new User();
            model = U.VizulizarePersoane(Admin);
            return View(model);
        }

    }
}