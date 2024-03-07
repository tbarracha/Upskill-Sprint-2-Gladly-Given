// Author: Tiago Barracha
// ti.barracha@gmail.com


using GladyGivenWebAPI.Data;
using GladyGivenWebAPI.Models;
using GladyGivenWebAPI.Models.DTOs;
using GladyGivenWebAPI.Services;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace GladyGivenWebAPI.Controllers
{
    [ApiController]
    [Route("api/v1/[controller]")]
    public class CostSupportController : ControllerBase
    {
        private readonly CostSupportService costService;

        public CostSupportController(CostSupportDBContext context)
        {
            costService = new CostSupportService(context);
        }

        [HttpGet]
        public async Task<ActionResult<IEnumerable<CostSupportDTO>>> GetAllCostSupports()
        {
            List<CostSupportDTO> costSupports = await costService.FindAllCostSupports();

            if (costSupports != null && costSupports.Count > 0)
                return Ok(costSupports);

            return NoContent();
        }

        [HttpGet("mycostsupports/{id}")]
        public async Task<ActionResult<IEnumerable<CostSupportDTO>>> GetAllCostSupportsById(int userId)
        {
            List<CostSupportDTO> costSupports = await costService.FindAllCostSupports();

            if (costSupports != null && costSupports.Count > 0)
                return Ok(costSupports);

            return NoContent();
        }

        [HttpGet("id")]
        public async Task<ActionResult<CostSupport>> GetCostSupport(int id)
        {
            CostSupportDTO costSupport = await costService.FindCostSupport(id);

            if (costSupport != null)
                return Ok(costSupport);

            return NoContent();
        }

        [HttpPost]
        public async Task<ActionResult<CostSupportDTO>> CreateCostSupport(CostSupportDTO cost)
        {
            CostSupportDTO costSupport = await costService.CreateCostSupport(cost);

            if (costSupport != null)
                return Ok(costSupport);

            return NoContent();
        }

        /*
        [HttpPut("id")]
        public async Task<ActionResult<CostSupportDTO>> UpdateCostSupport(int id, CostSupportDTO cost)
        {
            if (cost.Id != id)
            {
                return BadRequest();
            }

            CostSupportDTO updatedCost = await costService.UpdateCostSupport(cost);

            return Ok();
        }*/
    }
}
