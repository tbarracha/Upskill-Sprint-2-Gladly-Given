// Author: Tiago Barracha
// ti.barracha@gmail.com


using System.ComponentModel.DataAnnotations;

namespace GladyGivenWebAPI.Example
{
    public class ExampleModel
    {
        [Key]
        public int Id { get; set; }

        public string Name { get; set; }
    }
}
