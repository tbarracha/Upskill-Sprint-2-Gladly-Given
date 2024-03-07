using System.ComponentModel.DataAnnotations;
//Author: Clarissa
namespace GladyGivenWebAPI.Models
{
    public class Service
    {
        public long Id { get; set; }

        [MaxLength(100)]
        public string Description { get; set; }

        public virtual Category Category { get; set; } = new Category();

        public long CategoryId { get; set; } = 0;
       
    }
}
