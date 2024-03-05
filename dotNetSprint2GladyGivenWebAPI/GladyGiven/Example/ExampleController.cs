using Microsoft.AspNetCore.Mvc;

namespace GladyGivenWebAPI.Example
{
    [ApiController]
    [Route("api/v1/[controller]")]
    public class ExampleController : ControllerBase
    {
        private readonly ExampleService service;

        public ExampleController(ExampleDBContext context)
        {
            service = new ExampleService(context);
        }

        [HttpGet("~/api/health")]
        public ActionResult<string> Health()
        {
            return Ok("API is working fine!");
        }

        [HttpGet]
        public async Task<ActionResult<List<ExampleModel>>> GetAllExampleModels()
        {
            List<ExampleModel> models = await service.GetAllModels();

            if (models != null && models.Count > 0)
                return Ok(models);
            
            return NoContent();
        }

        [HttpPost]
        public async Task<ActionResult<ExampleModel>> CreateExampleModel(string name)
        {
            ExampleModel model = await service.CreateExampleModel(name);

            if (model != null)
                return Ok(model);

            return NoContent();
        }
    }
}
