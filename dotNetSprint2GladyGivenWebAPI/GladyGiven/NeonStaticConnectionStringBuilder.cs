using Npgsql;

namespace GladyGivenWebAPI
{
    /// <summary>
    /// Class to give privacy to our db connection string. Probably overkill, but it will be added to the gitIgnore so it isn't added to gitHub
    /// </summary>
    public static class NeonStaticConnectionStringBuilder
    {
        public static string GetNpgsqlConnectionString()
        {
            var neonBuilder = new NpgsqlConnectionStringBuilder();
            neonBuilder.Host = "ep-yellow-sun-a20w7lo3.eu-central-1.aws.neon.tech";
            neonBuilder.Database = "gladlyGiven";
            neonBuilder.Username = "upskill.sprint.final";
            neonBuilder.Password = "76nfceumUQBY";

            return neonBuilder.ConnectionString;
        }
    }
}

