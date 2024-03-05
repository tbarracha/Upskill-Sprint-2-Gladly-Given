using Microsoft.EntityFrameworkCore;

namespace GladyGivenWebAPI.Example
{
    public class ExampleDBContext : DbContext
    {
        public DbSet<ExampleModel> ExampleModels { get; set; }

        public ExampleDBContext(DbContextOptions options) : base(options)
        {

        }
    }
}
