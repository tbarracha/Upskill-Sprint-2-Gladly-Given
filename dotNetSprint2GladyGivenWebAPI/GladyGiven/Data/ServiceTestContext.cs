using GladyGivenWebAPI.Models;
using Microsoft.EntityFrameworkCore;

namespace GladyGivenWebAPI.Data
{
    public class ServiceTestContext : DbContext 
    {
        public ServiceTestContext(DbContextOptions<ServiceTestContext> options) : base(options)
        {

        }

    public DbSet<Category> Categories { get; set; }

    public DbSet<Service> Services { get; set; }
    }
}
