﻿using System.ComponentModel.DataAnnotations;

namespace GladyGivenWebAPI.Models
{
    public class ServiceDTO
    {
        public long Id { get; set; }

        [MaxLength(100)]
        public string Description { get; set; }

        public long CategoryId { get; set; } = 0;
    }
}