using GladyGivenWebAPI.Models;
using Microsoft.EntityFrameworkCore;

namespace GladyGivenWebAPI.Data
{
    public class ServicesContext : DbContext 
    {
        public ServicesContext(DbContextOptions<ServicesContext> options) : base(options)
        {

        }

        public DbSet<Category> Category { get; set; }

        public DbSet<Service> Service { get; set; }
    }
}
