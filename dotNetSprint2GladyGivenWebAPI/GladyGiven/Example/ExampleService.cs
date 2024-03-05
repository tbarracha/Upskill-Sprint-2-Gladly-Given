using Microsoft.EntityFrameworkCore;

namespace GladyGivenWebAPI.Example
{
    public class ExampleService
    {
        private readonly ExampleDBContext context;

        public ExampleService(ExampleDBContext context)
        {
            this.context = context;
        }

        public async Task<List<ExampleModel>> GetAllModels()
        {
            return await context.ExampleModels.ToListAsync();
        }

        public async Task<ExampleModel> CreateExampleModel(string name)
        {
            ExampleModel model = await context.ExampleModels.FirstOrDefaultAsync(m => m.Name == name);

            if (model == null)
            {
                model = new ExampleModel { Name = name };
                context.ExampleModels.Add(model);
                context.SaveChanges();
            }

            return model;
        }
    }
}
