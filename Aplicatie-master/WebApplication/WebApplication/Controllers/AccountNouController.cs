using Microsoft.AspNet.Identity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Security;
using WebApplication.DTO;
using WebApplication.Models;



namespace WebApplication.Controllers
{
    public class AccountNouController : Controller
    {

        // GET: /AccountControllerNou/

        //aceasta clasa este una in care se fac operati doar pentru logare, inregistrare si logoff aceste actiuni sunt importante pentru un utilizator
        public ActionResult Index()
        {
            return View();
        }
        public ActionResult AdminPage(string username)
        {
            VizualizareCont model = new VizualizareCont();
            User U = new User();
            model = U.VizualizareC(username);
            return View(model);
        }
        //[Authorize]
        public ActionResult Login()
        {
            return View();
        }
       
        [HttpPost]
        [AllowAnonymous]
        [ValidateAntiForgeryToken]
        public ActionResult Login(LoginModel model)
        {
            User U=new User();
            if(ModelState.IsValid)
            {
                var user = U.Logare(model.UserName, model.Password);
                if(user=="USER")
                {
                    FormsAuthentication.SetAuthCookie(model.UserName, false);
                    return RedirectToAction("VizualizareCont","Vizualizare",new { username= model.UserName });
                }

                    if (user=="ADMIN")
                    {
                        //Roles.FindUsersInRole("Administrator", "Administrator");
                        FormsAuthentication.SetAuthCookie(model.UserName, false);
                        return RedirectToAction("AdminPage", "AccountNou", new { username = model.UserName });
                    }
                    else
                    {
                        ModelState.AddModelError("", "Invalid username or password.");
                    }
                
                
            }
            return View(model);
        }
        public ActionResult Create()
        {
            return View();
        }
        [HttpPost]
        [AllowAnonymous]
        [ValidateAntiForgeryToken]
        public ActionResult Create( RegisterModel model)
        {
            User U=new User();
            if (ModelState.IsValid)
            {
                bool user =U.Introducere(model.UserName,model.FirstName,model.LastName,model.Password,model.Admin,model.Varsta);
                if(user!=false)
                {
                    return RedirectToAction("Index", "AccountNou");
                }
            }
            return View(model);
        }
        
        [HttpPost]
        [AllowAnonymous]
        [ValidateAntiForgeryToken]
        public ActionResult LogOff()
        {
            FormsAuthentication.SignOut();
            return RedirectToAction("Login", "AccountNou");
        }
        

    }
	
}