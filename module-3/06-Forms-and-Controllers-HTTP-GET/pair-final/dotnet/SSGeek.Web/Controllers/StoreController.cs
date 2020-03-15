using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using SSGeek.Web.DAL;
using SSGeek.Web.Extensions;
using SSGeek.Web.Models;

namespace SSGeek.Web.Controllers
{
    public class StoreController : Controller
    {
        private const string ShoppingCart_SessionKey = "ShoppingCart";
        private readonly IProductDAO productDao;

        public StoreController(IProductDAO productDao)
        {
            this.productDao = productDao;
        }

        // GET: Store
        public IActionResult Index()
        {
            var products = productDao.GetProducts();
            return View("Index", products);
        }

        // GET: Store/Detail/id
        public IActionResult Detail(int id)
        {
            // Check to make sure that the id is for a valid product
            var product = productDao.GetProduct(id);

            if (product == null)
            {
                return NotFound(); //404
            }

            return View("Detail", product);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public IActionResult AddToCart(int productId, int quantity)
        {
            // Check to make sure that they are purchasing a valid product
            var product = productDao.GetProduct(productId);

            if (product == null)
            {
                return NotFound();
            }

            // Check to see if a shopping cart exists in session, if not create it
            var shoppingCart = HttpContext.Session.Get<ShoppingCart>(ShoppingCart_SessionKey) ?? new ShoppingCart();
            
            // Add the product or update the quantity
            shoppingCart.AddOrUpdateCart(product, quantity);

            // Save the cart to session
            HttpContext.Session.Set(ShoppingCart_SessionKey, shoppingCart);

            return RedirectToAction("ViewCart");
        }

        // GET: Store/ViewCart
        public IActionResult ViewCart()
        {
            // Retrieve cart from session
            ShoppingCart model = HttpContext.Session.Get<ShoppingCart>(ShoppingCart_SessionKey) ?? new ShoppingCart();
            return View("ViewCart", model);
        }

        
    }
}