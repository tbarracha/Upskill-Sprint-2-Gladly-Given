using System;
using System.ComponentModel.DataAnnotations;

namespace GladyGivenWebAPI.Models
{
	public class Category
	{
		[Key]
		public long Id { get; set; }

		public string Name { get; set; }

		public Category()
		{
		}
	}
}

