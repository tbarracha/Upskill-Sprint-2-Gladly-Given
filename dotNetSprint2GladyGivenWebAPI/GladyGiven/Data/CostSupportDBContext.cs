// Author: Lia Araruna

using GladyGivenWebAPI.Models;
using Microsoft.EntityFrameworkCore;

namespace GladyGivenWebAPI.Data
{
    public class CostSupportDBContext : DbContext
    { 
        public DbSet<CostSupport> CostSupports { get; set; }

        public CostSupportDBContext(DbContextOptions options) : base(options)
        {

        }
    }
}
