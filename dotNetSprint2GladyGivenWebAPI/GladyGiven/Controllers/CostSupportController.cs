// Author: Tiago Barracha
// ti.barracha@gmail.com


using GladyGivenWebAPI.Data;
using GladyGivenWebAPI.Example;
using GladyGivenWebAPI.Models;
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

        /*
        [HttpGet("~/api/health")] // landing
        public ActionResult<string> Health()
        {
            return Ok("Entity API is working fine!");
        }*/


        [HttpGet("/costsupports")]
        public async Task<ActionResult<IEnumerable<CostSupport>>> FindAllCostSupports()
        {
            List<CostSupport> costSupports = await costService.FindAllCostSupports();

            if (costSupports != null && costSupports.Count > 0)
                return Ok(costSupports);

            return NoContent();
        }

        [HttpGet("id")]
        public async Task<ActionResult<CostSupport>> FindCostSupport(int id)
        {
            CostSupport costSupport = await costService.FindCostSupport(id);

            if (costSupport != null)
                return Ok(costSupport);

            return NoContent();
        }

        [HttpPost]
        public async Task<ActionResult<CostSupport>> CreateCostSupport(CostSupport cost)
        {
            CostSupport costSupport = await costService.CreateCostSupport(cost);

            if (costSupport != null)
                return Ok(costSupport);

            return NoContent();
        }

        [HttpPut("id")]
        public async Task<ActionResult<CostSupport>> UpdateCostSupport(int id, CostSupport cost)
        {
            if (cost.Id != id)
            {
                return BadRequest();
            }

            CostSupport updatedCost = await costService.UpdateCostSupport(cost);

            return Ok();
        }
    }
}
