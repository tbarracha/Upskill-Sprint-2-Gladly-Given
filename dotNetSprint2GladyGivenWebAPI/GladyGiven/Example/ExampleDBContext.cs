// Author: Tiago Barracha
// ti.barracha@gmail.com


using Microsoft.EntityFrameworkCore;

namespace GladyGivenWebAPI.Example
{
    public class ExampleDBContext : DbContext
    {
        public DbSet<ExampleModel> ExampleModels { get; set; } // repository in Java Spring

        public ExampleDBContext(DbContextOptions options) : base(options)
        {

        }
    }
}
