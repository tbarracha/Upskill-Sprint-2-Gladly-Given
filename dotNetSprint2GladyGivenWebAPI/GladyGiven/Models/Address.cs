using System;
namespace GladyGivenWebAPI.Models
{
	public class Address
	{
		public string City { get; set; }

		public string StreetName { get; set; }

		public int BuildingNumber { get; set; }

		public string PostalCode { get; set; }

		public Address()
		{
		}
	}
}

