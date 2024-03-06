using System;
using System.ComponentModel.DataAnnotations;

namespace GladyGivenWebAPI.Models
{
	public class PaymentInfo
	{
        [Key]
		public long Id { get; set; }

		public long UserId { get; set; }

		public string Iban { get; set; }

		public PaymentInfo()
		{
		}
	}
}

