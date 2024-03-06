using System;
using System.ComponentModel.DataAnnotations;

namespace GladyGivenWebAPI.Models
{
	public class Invoice
	{
		[Key]
		public long Id { get; set; }

		public long UserId { get; set; }

		public PaymentInfo PayInfo { get; set; }

		public double Amount { get; set; }

		public DateTime CreationDate { get; set; }

		public Invoice()
		{
		}
	}
}

