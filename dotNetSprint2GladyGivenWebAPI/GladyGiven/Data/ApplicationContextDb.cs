using GladyGivenWebAPI.Models;
using Microsoft.EntityFrameworkCore;

namespace GladyGivenWebAPI.Data
{
    public class ApplicationContextDb : DbContext 
    {
        public ApplicationContextDb(DbContextOptions<ApplicationContextDb> options) : base(options)
        {

        }

        public DbSet<Category> Category { get; set; }

        public DbSet<Service> Service { get; set; }
    }
}
