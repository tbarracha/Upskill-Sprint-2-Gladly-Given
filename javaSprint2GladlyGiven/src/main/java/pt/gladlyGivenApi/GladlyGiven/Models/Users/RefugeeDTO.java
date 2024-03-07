// Author: Tiago Barracha
// ti.barracha@gmail.com

package pt.gladlyGivenApi.GladlyGiven.Models.Users;

public class RefugeeDTO extends AppUserDTO {
    public String protocolId;

    public String snsNumber;

    public String nationality;

    public String country;

    public RefugeeDTO(String firstName, String lastName, String email, String gender, String photoURL, String mainLanguage, String mainPhoneNumber, String protocolId, String snsNumber, String nationality, String country) {
        super(firstName, lastName, email, gender, photoURL, mainLanguage, mainPhoneNumber);
        this.protocolId = protocolId;
        this.snsNumber = snsNumber;
        this.nationality = nationality;
        this.country = country;
    }
}
