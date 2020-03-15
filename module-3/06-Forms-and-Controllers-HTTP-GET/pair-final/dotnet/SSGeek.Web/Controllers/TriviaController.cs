using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using SSGeek.Web.Models;

namespace SSGeek.Web.Controllers
{
    public class TriviaController : Controller
    {
        // GET: Trivia
        public IActionResult Index()
        {
            return View("Index", new TriviaModel());
        }

        [HttpPost]
        public IActionResult Index(TriviaModel model)
        {
            TempData.Add("Name", model.Name);
            if (model.SubmittedAnswer == "Neil Armstrong")
            {
                return RedirectToAction("Correct");
            }
            else
            {
                return RedirectToAction("Incorrect");
            }
        }

        public IActionResult Correct()
        {
            var model = new TriviaModel
            {
                Name = (string)TempData["Name"]
            };
            return View("Correct", model);
        }

        public IActionResult Incorrect()
        {
            var model = new TriviaModel
            {
                Name = (string)TempData["Name"]
            };
            return View("Incorrect", model);
        }
    }
}