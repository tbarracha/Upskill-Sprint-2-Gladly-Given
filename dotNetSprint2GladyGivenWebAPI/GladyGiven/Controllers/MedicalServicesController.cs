using Castle.Core.Resource;
using GladyGivenWebAPI.Data;
using GladyGivenWebAPI.Models;
using GladyGivenWebAPI.Services;
using Microsoft.AspNetCore.Http.HttpResults;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace GladyGivenWebAPI.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class MedicalServicesController : ControllerBase
    {
        private readonly MedicalServices core;

        public MedicalServicesController(ServicesContext context)
        {
            this.core = new MedicalServices(context);
        }

        [HttpGet("/services")]
        public async Task<ActionResult<IEnumerable<Service>>> GetAllServices()
        {
            var services = await core.FindAllServices();

            if (services == null)
            {
                return NoContent();
            }

            return Ok(services);
        }

        [HttpGet("/service/{id}")]
        public async Task<ActionResult<Service>> GetService(int id)
        {
            var service = await core.FindServiceById(id);

            if (id == null)
            {
                return BadRequest();
            }

            if (service == null)
            {
                return NotFound();
            }

            return Ok(service);
        }

        [HttpPost("/service")]
        public async Task<ActionResult<Service>> AddService(ServiceDTO service)
        {
            if (service == null)
            {
                return BadRequest();
            }

            var newService = await core.AddService(service);
            
            if (newService == null)
            {
                return BadRequest();
            }

            return Ok(newService);
        }

        [HttpPut("/service/{id}")]
        public async Task<ActionResult<Service>> UpdateService(long id, Service service)
        {
            if (service.Id != id)
            {
                return BadRequest();
            }

            Service updatedService;

            try
            {
                updatedService = await core.UpdateSevice(service);
            }
            catch (Exception e)
            {
                return NotFound($"Service if id {id} not found");
            }

            return Ok(updatedService);
        }

        [HttpDelete("/service/{id}")]
        public async Task<IActionResult> DeleteService(long id)
        {
            var service = await core.FindServiceById(id);

            if (service == null)
            {
                return BadRequest();
            }

            await core.DeleteService(id);
            return Ok(service);

        }

        [HttpGet("/categories")]
        public async Task<ActionResult<IEnumerable<Category>>> GetCategories()
        {
            var categories = await core.FindAllCategories();
            if(categories == null)
            {
                return BadRequest();
            }
            return Ok(categories);
        }

        [HttpGet("/category/{id}")]
        public async Task<ActionResult<Category>> GetCategoryById(long id)
        {
            var category = await core.FindCategoryById(id);
            if (category == null)
            {
                return NotFound();
            }

            return Ok(category);
        }

        [HttpPost("/category")]
        public async Task<ActionResult<Category>> AddCategory(Category category)
        {
            try
            {
                var newCategory = await core.AddCategory(category);
                return CreatedAtAction(nameof(GetCategoryById), new { id = category.Id }, category);
            }catch (Exception ex)
            {
                return NoContent();
            }
        }

        [HttpDelete("/category/{id}")]
        public async Task<IActionResult> DeleteCategory(long id)
        {
            var category = await core.FindCategoryById(id);

            if (category == null)
            {
                return NotFound();
            }

            await core.DeleteCategory(id);
            return NoContent();
        }

            
    }
}
