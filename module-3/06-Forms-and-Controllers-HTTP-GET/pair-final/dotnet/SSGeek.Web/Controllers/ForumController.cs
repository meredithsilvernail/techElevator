using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using SSGeek.Web.DAL;
using SSGeek.Web.Models;

namespace SSGeek.Web.Controllers
{
    public class ForumController : Controller
    {
        private readonly IForumPostDAO forumDao;

        public ForumController(IForumPostDAO forumDao)
        {
            this.forumDao = forumDao;
        }


        // GET: Forum
        public IActionResult Index()
        {
            List<ForumPost> posts = forumDao.GetAllPosts();
            return View("Index", posts);
        }

        public IActionResult NewPost()
        {
            return View("NewPost", new ForumPost());
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public IActionResult NewPost(ForumPost post)
        {
            var result = forumDao.SaveNewPost(post);

            TempData["Message_Success"] = true;

            return RedirectToAction("Index");
        }
    }
}