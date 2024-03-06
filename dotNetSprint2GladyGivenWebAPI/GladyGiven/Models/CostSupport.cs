using System;
using System.ComponentModel.DataAnnotations;
using GladyGivenWebAPI.Enums;

namespace GladyGivenWebAPI.Models
{
	public class CostSupport
	{
		[Key]
		public long Id { get; set; }

		public double Amount { get; set; }

		public long ServiceProviderId { get; set; }

		public string Description { get; set; }

		public CostSupportStatus Status { get; set; }

		public CostSupportType Type { get; set; }

		public CostSupport()
		{
		}
	}
}

