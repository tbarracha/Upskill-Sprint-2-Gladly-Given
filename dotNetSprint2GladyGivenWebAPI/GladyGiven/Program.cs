using GladyGivenWebAPI;
using GladyGivenWebAPI.Data;
using Microsoft.EntityFrameworkCore;

namespace GladyGiven
{
    public class Program
    {
        public static void Main(string[] args)
        {
            var builder = WebApplication.CreateBuilder(args);

            // Add services to the container.
            
            //builder.Services.AddDbContext<ServiceTestContext>(options =>
            //    options.UseOracle(builder.Configuration.GetConnectionString("GGServiceTestDb")
            //    )
            //  );

            string connectionString = NeonStaticConnectionStringBuilder.GetNpgsqlConnectionString();
            builder.Services.AddDbContext<ServicesContext>(options =>
                options.UseNpgsql(connectionString));

            builder.Services.AddControllers();
            // Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
            builder.Services.AddEndpointsApiExplorer();
            builder.Services.AddSwaggerGen();

            var app = builder.Build();

            // Configure the HTTP request pipeline.
            if (app.Environment.IsDevelopment())
            {
                app.UseSwagger();
                app.UseSwaggerUI();
            }

            app.UseHttpsRedirection();

            app.UseAuthorization();


            app.MapControllers();

            app.Run();
        }
    }
}
