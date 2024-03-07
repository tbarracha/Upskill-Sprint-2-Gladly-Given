using System.ComponentModel.DataAnnotations;
//Author: Clarissa

namespace GladyGivenWebAPI.Models
{
    public class Category
    {
        public long Id { get; set; }

        [MaxLength(50)]
        public string? Name { get; set; }
    }
}
