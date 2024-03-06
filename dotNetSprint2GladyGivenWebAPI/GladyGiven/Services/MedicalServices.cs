using GladyGivenWebAPI.Data;
using GladyGivenWebAPI.Models;
using Microsoft.AspNetCore.Http.HttpResults;
using Microsoft.EntityFrameworkCore;
using System.Collections;

namespace GladyGivenWebAPI.Services
{
    public class MedicalServices
    {
        public readonly ServiceTestContext context;

        public MedicalServices(ServiceTestContext context)
        {
            this.context = context;
        }

        public async Task<IEnumerable<Service>> FindAllServices()
        {
            var services = await context.Services.Include(p => p.Category).ToListAsync();
            return services;
        }

        public async Task<Service> FindServiceById(long id) 
        {
            var service = await context.Services.Include(p => p.Category).FirstOrDefaultAsync(p => p.Id == id);
            if (service == null)
            {
                return null;
            }
            return service;
        }

        public async Task<Service> AddService(ServiceDTO serviceDTO)
        {
            var category = await context.Categories.FirstOrDefaultAsync(x => x.Id == serviceDTO.CategoryId);

            if(category == null)
            {
                category = new Category();
            }

            var service = new Service { 
                    Id = serviceDTO.Id, 
                    Description = serviceDTO.Description,
                    CategoryId = serviceDTO.CategoryId,
                    Category = category };

            context.Services.Add(service);
            context.SaveChanges();

            return service;
        }

        public async Task<Service> UpdateSevice(Service service) 
        {
            if (!context.Services.Any(m => m.Id == service.Id))
            {
                throw new Exception("Customer does not exist");
            }

            context.Services.Entry(service).State = EntityState.Modified;
            await context.SaveChangesAsync();
            return service;
        }

        public async Task<Service> DeleteService(long id)
        {
            var service = await context.Services.SingleOrDefaultAsync(x => x.Id == id);

            if (service == null)
            {
                throw new Exception($"Service with id {id} does not exist");
            }

            context.Services.Remove(service);
            context.SaveChanges();
            return service;
        }
        public async Task<IEnumerable<Category>> FindAllCategories()
        {
            var categories = await context.Categories.ToListAsync();
            return categories;
        }

        public async Task<Category> FindCategoryById(long id) 
        {
            var category = await context.Categories.FirstOrDefaultAsync(p => p.Id == id);
            if (category == null)
            {
                return null;
            }
            return category;
        }

        public async Task<Category> AddCategory(Category category)
        {

            if(category == null)
            {
                return null;
            }

            context.Categories.Add(category);
            await context.SaveChangesAsync();

            return category;
        }

        public async Task<Category> UpdateCategory(Category category) 
        {
            if (!context.Services.Any(m => m.Id == category.Id))
            {
                throw new Exception("Category does not exist");
            }

            context.Categories.Entry(category).State = EntityState.Modified;
            await context.SaveChangesAsync();
            return category;
        }

        public async Task<Category> DeleteCategory(long id)
        {
            var category = await context.Categories.SingleOrDefaultAsync(x => x.Id == id);

            if (category == null)
            {
                throw new Exception($"Category with id {id} does not exist");
            }

            context.Categories.Remove(category);
            context.SaveChanges();
            return category;
        }
    }
}
