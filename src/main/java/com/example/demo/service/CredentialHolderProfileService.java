public interface CredentialHolderProfileService {

    CredentialHolderProfile createProfile(CredentialHolderProfile profile);

    List<CredentialHolderProfile> getAllProfiles();

    CredentialHolderProfile getProfileById(Long id);

    CredentialHolderProfile updateProfile(Long id, CredentialHolderProfile profile);

    void updateStatus(Long id, boolean active);

    void deleteProfile(Long id);
}
