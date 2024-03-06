using System;
using System.ComponentModel.DataAnnotations;
using GladyGivenWebAPI.Enums;

namespace GladyGivenWebAPI.Models
{
	public class Donation
	{
		[Key]
		public long Id { get; set; }

		public long UserId { get; set; }

		public double Amount { get; set; }

		public DonationType typeOfDonation { get; set; }

		public DateTime Date { get; set; }

		public Donation()
		{
		}
	}
}

