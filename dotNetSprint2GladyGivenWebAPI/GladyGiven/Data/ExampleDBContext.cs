// Author: Tiago Barracha
// ti.barracha@gmail.com


using GladyGivenWebAPI.Example;
using Microsoft.EntityFrameworkCore;

namespace GladyGivenWebAPI.Data
{
    public class ExampleDBContext : DbContext
    {
        public DbSet<ExampleModel> ExampleModels { get; set; } // repository in Java Spring

        public ExampleDBContext(DbContextOptions options) : base(options)
        {

        }
    }
}
