using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace SSGeek.Web.Models
{
    public class TriviaModel
    {
        [Display(Name = "Enter your name:")]
        public string Name { get; set; }

        [Display(Name = "Who first walked on the moon?")]
        public string SubmittedAnswer { get; set; }        
    }
}