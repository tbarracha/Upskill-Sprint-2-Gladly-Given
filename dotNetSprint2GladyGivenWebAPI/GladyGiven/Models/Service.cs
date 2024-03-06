using System;
using System.ComponentModel.DataAnnotations;

namespace GladyGivenWebAPI.Models
{
	public class Service
	{
		[Key]
		public long Id { get; set; }

		public Category ServiceCategory { get; set; }

		public string Description { get; set; }

		public Service()
		{
		}
	}
}

