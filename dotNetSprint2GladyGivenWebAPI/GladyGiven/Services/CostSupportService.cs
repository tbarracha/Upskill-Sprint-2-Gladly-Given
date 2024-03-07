///Author: Lia Araruna

using System;
using GladyGivenWebAPI.Data;
using GladyGivenWebAPI.Models;
using GladyGivenWebAPI.Models.DTOs;
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

        /// <summary>
        /// Administrator views all cost supports requested
        /// </summary>
        /// <returns>List of all cost supports requested</returns>
        public async Task<List<CostSupportDTO>> FindAllCostSupports()
        {
            List<CostSupport> costSupports = await context.CostSupports.ToListAsync();

            if(costSupports == null)
            {
                return null; //TODO: alterar para exceção TableIsEmpty();
            }

            List<CostSupportDTO> costSupportDTOs = new List<CostSupportDTO>();

            foreach (CostSupport cost in costSupports)
            {
                CostSupportDTO costSupportDTO = new CostSupportDTO(cost);
                costSupportDTOs.Add(costSupportDTO);
            }

            return costSupportDTOs;
        }

        /// <summary>
        /// Service provider views all cost supports requested by him.
        /// </summary>
        /// <param name="userId">Service provider id</param>
        /// <returns>List of all cost supports requested by a service provider</returns>
        public async Task<List<CostSupportDTO>> FindAllCostSupportsById(int userId)
        {
            List<CostSupport> costSupports = await context.CostSupports
                .Where(sp => sp.Id == userId)
                .ToListAsync();

            if (costSupports == null)
            {
                //TODO: alterar para exceção ThereIsNoCostSupportException();
                return null;
            }

            List<CostSupportDTO> costSupportDTOs = new List<CostSupportDTO>();

            foreach(CostSupport cost in costSupports)
            {
                CostSupportDTO costSupportDTO = new CostSupportDTO(cost);
                costSupportDTOs.Add(costSupportDTO);
            }

            return costSupportDTOs;
        }

        /// <summary>
        /// Find a specific cost support by its id
        /// </summary>
        /// <param name="id">Cost support id</param>
        /// <returns>Cost support</returns>
        public async Task<CostSupportDTO> FindCostSupport(int id)
        {
            var costSupport = await context.CostSupports.FirstOrDefaultAsync(cs => cs.Id == id);
            if (costSupport == null)
            {
                throw new NotImplementedException(); //TODO: alterar para exceção EntityDoesntExistsException();
            }

            CostSupportDTO costSupportDTO = new CostSupportDTO(costSupport);

            return costSupportDTO;
        }

        /// <summary>
        /// Service provider requests a cost support.
        /// </summary>
        /// <param name="cost">Cost support DTO</param>
        /// <returns>costSupportDTO</returns>
        public async Task<CostSupportDTO> CreateCostSupport(CostSupportDTO cost)
        {
            var costSupport = await context.CostSupports.FirstOrDefaultAsync(cs => cs.Id == cost.Id);

            if (costSupport == null)
            {
                costSupport = new CostSupport { Amount = cost.Amount, Description = cost.Description,
                    ServiceProviderId = cost.ServiceProviderId, Status = Enums.CostSupportStatus.PENDING,
                    Type = cost.Type };
                context.CostSupports.Add(costSupport);
                context.SaveChanges();
            }

            CostSupportDTO costSupportDTO = new CostSupportDTO(costSupport);

            return costSupportDTO;
        }



        /// <summary>
        /// Administrator validates a cost support requested.
        /// </summary>
        /// <param name="cost">Cost support to be validated</param>
        /// <returns>Cost support status updated</returns>
        /*
        public async Task<CostSupportDTO> UpdateCostSupport(CostSupportDTO cost)
        {
           
        }*/
    }
}

