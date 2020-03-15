using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using SSGeek.Web.Models;

namespace SSGeek.Web.DAL
{
    public interface IProductDAO
    {
        List<Product> GetProducts();
        Product GetProduct(int id);
    }
}
