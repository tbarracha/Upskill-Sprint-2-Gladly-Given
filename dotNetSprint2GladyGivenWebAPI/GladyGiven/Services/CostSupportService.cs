using System;
using GladyGivenWebAPI.Data;
using GladyGivenWebAPI.Models;
using Microsoft.EntityFrameworkCore;

namespace GladyGivenWebAPI.Services
{
	public class CostSupportService
	{
		private readonly CostSupportDBContext context;

        public CostSupportService(CostSupportDBContext context)
		{
			this.context = context;
		}

        public async Task<List<CostSupport>> FindAllCostSupports()
        {
            List<CostSupport> costSupports = await context.CostSupports.ToListAsync();

            if(costSupports == null)
            {
                return null;
            }
            return costSupports;
        }

        public async Task<CostSupport> FindCostSupport(int id)
        {
            var costSupport = await context.CostSupports.FirstOrDefaultAsync(m => m.Id == id);
            if (costSupport == null)
            {
                return null; //TODO: inserir exceção.
            }
            return costSupport;
        }

        public async Task<CostSupport> CreateCostSupport(CostSupport cost)
        {
            var costSupport = await context.CostSupports.FirstOrDefaultAsync(m => m.Description == cost.Description);

            if (costSupport == null)
            {
                costSupport = new CostSupport { Id = cost.Id, Amount = cost.Amount, Description = cost.Description, ServiceProviderId = cost.ServiceProviderId, Status = cost.Status, Type = cost.Type };
                context.CostSupports.Add(costSupport);
                context.SaveChanges();
            }

            return costSupport;
        }

        public async Task<CostSupport> UpdateCostSupport(CostSupport cost)
        {
            var updatedCostSupport = context.CostSupports.Entry(cost);
            updatedCostSupport.State = EntityState.Modified;
            await context.SaveChangesAsync();

            return updatedCostSupport.Entity;
        }
    }
}

