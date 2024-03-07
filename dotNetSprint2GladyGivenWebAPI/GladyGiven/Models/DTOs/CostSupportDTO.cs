using System;
using GladyGivenWebAPI.Enums;

namespace GladyGivenWebAPI.Models.DTOs
{
	public class CostSupportDTO
	{
        public long Id { get; set; }

        public double Amount { get; set; }

        public string Description { get; set; }

        public long ServiceProviderId { get; set; }

        public CostSupportType Type { get; set; }

        public CostSupportDTO()
        {
        }

        public CostSupportDTO(CostSupport costSupport)
        {
            this.Id = costSupport.Id;
            this.Amount = costSupport.Amount;
            this.Description = costSupport.Description;
            this.ServiceProviderId = costSupport.ServiceProviderId;
            this.Type = costSupport.Type;
        }
    }
}

