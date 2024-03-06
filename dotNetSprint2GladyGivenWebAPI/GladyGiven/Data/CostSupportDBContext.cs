// Author: Tiago Barracha
// ti.barracha@gmail.com

using GladyGivenWebAPI.Example;
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
