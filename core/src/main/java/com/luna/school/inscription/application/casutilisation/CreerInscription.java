package com.luna.school.inscription.application.casutilisation;

import com.luna.school.classe.application.port.ClasseRepositoryPort;
import com.luna.school.classe.domaine.entite.Classe;
import com.luna.school.comptabilite.domaine.entite.Comptabilite;
import com.luna.school.etudiant.application.gestionnairecommande.CreerEtudiantCommende;
import com.luna.school.etudiant.application.gestionnairecommande.CreerParentMereEtudiantCommande;
import com.luna.school.etudiant.application.gestionnairecommande.CreerPereEtudiantCommande;
import com.luna.school.etudiant.application.gestionnairecommande.CreerTuTeurEtudiantCommande;
import com.luna.school.etudiant.application.port.EtudiantRepositoryPort;
import com.luna.school.etudiant.application.port.MereEtudiantRepositoryPort;
import com.luna.school.etudiant.application.port.PereEtudiantRepositoryPort;
import com.luna.school.etudiant.application.port.TuteurRepositoryPort;
import com.luna.school.etudiant.domaine.entite.Etudiant;
import com.luna.school.etudiant.domaine.entite.ParentMereEtudiant;
import com.luna.school.etudiant.domaine.entite.ParentPereEtudiant;
import com.luna.school.etudiant.domaine.entite.TuteurEtudiant;
import com.luna.school.inscription.application.commande.CreerInscriptionCommande;
import com.luna.school.inscription.application.port.InscriptionRepositoryPort;
import com.luna.school.inscription.domaine.entite.Inscription;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import java.util.logging.Logger;

/**
 * @author BOUA YVES 2024-04-21
 */
public class CreerInscription {
  private final Logger logger = Logger.getLogger(CreerInscription.class.getName());
private final InscriptionRepositoryPort inscriptionRepositoryPort;
private final PereEtudiantRepositoryPort pereEtudiantRepositoryPort;
private final MereEtudiantRepositoryPort mereEtudiantRepositoryPort;
private final TuteurRepositoryPort tuteurRepositoryPort;
private final EtudiantRepositoryPort etudiantRepositoryPort;
private final ClasseRepositoryPort classeRepositoryPort;
  public CreerInscription(InscriptionRepositoryPort inscriptionRepositoryPort,
      PereEtudiantRepositoryPort pereEtudiantRepositoryPort,
      MereEtudiantRepositoryPort mereEtudiantRepositoryPort,
      TuteurRepositoryPort tuteurRepositoryPort, EtudiantRepositoryPort etudiantRepositoryPort,
      ClasseRepositoryPort classeRepositoryPort) {
    this.inscriptionRepositoryPort = inscriptionRepositoryPort;
    this.pereEtudiantRepositoryPort = pereEtudiantRepositoryPort;
    this.mereEtudiantRepositoryPort = mereEtudiantRepositoryPort;
    this.tuteurRepositoryPort = tuteurRepositoryPort;
    this.etudiantRepositoryPort = etudiantRepositoryPort;
    this.classeRepositoryPort = classeRepositoryPort;
  }

  public void creer(CreerInscriptionCommande commande){
    Inscription inscription = this.genererInscription(commande);
    this.inscriptionRepositoryPort.enregistrer(inscription);
    logger.info("inscription effectuée avec succès !");
  }

  private Inscription genererInscription(CreerInscriptionCommande commande) {
    Classe classePrecedente = this.classeRepositoryPort.recupererParId(commande.getClassePrecedanteId());
    Classe classeActuelle = this.classeRepositoryPort.recupererParId(commande.getClasseActuelleId());
    Etudiant etudiant = this.genererEtudiant(commande.getCreerEtudiantCommende());
    BigDecimal montantScolarite = classeActuelle.getNiveau().getMontantScolarite();
    BigDecimal montantVerset = commande.getMontantVerset();
    var comptabilite = new Comptabilite();
    comptabilite.setId(UUID.randomUUID());
    comptabilite.setScolariteTotale(montantScolarite);
    comptabilite.setMontantVerset(montantVerset);
    BigDecimal reste = montantScolarite.subtract(montantVerset);
    comptabilite.setReste(reste);
    comptabilite.setEtudiant(etudiant);
    var inscription = new Inscription();
    inscription.setId(UUID.randomUUID());
    inscription.setDateInscription(LocalDate.now());
    inscription.setClassePrecedante(classePrecedente);
    inscription.setClasseActuelle(classeActuelle);
    inscription.setDroitInscription(commande.isDroitInscription());
    inscription.setBoursier(commande.isBoursier());
    inscription.setRedouble(commande.isRedouble());
    inscription.setDecisionFinAnnee(commande.getDecisionFinAnnee());
    inscription.setDeposerPhoto(commande.isDeposerPhoto());
    inscription.setEtablissementPrecedante(commande.getEtablissementPrecedante());
    inscription.setFairePremierVersement(commande.isFairePremierVersement());
    inscription.setLieuNaissance(commande.getCreerEtudiantCommende().getLieuNaissance());
    inscription.setExtraitNaisaance(commande.isExtraitNaisaance());
    inscription.setNumeroExtraitNaissance(commande.getNumeroExtraitNaissance());
    inscription.setEtudiant(etudiant);
    return inscription;
  }



  private Etudiant genererEtudiant(CreerEtudiantCommende commande) {
    var etudiant = new Etudiant();
    ParentPereEtudiant parentPereEtudiant = this.genererParentPere(
        commande.getParentPereCommande());
    ParentMereEtudiant parentMereEtudiant = this.genererMere(commande.getParentMereCommande());
    TuteurEtudiant tuteurEtudiant = this.genererTuteur(commande.getTuTeurEtudiantCommande());
    etudiant.setId(UUID.randomUUID());
    etudiant.setCivilite(commande.getCivilite());
    etudiant.setStatut(commande.getStatut());
    etudiant.setBoursier(commande.isBoursier());
    etudiant.setMatricule(commande.getMatricule());
    etudiant.setNom(commande.getNom());
    etudiant.setPrenoms(commande.getPrenoms());
    etudiant.setDateNaissance(commande.getDateNaissance());
    etudiant.setLieuNaissance(commande.getLieuNaissance());
    etudiant.setNationnailite(commande.getNationnailite());
    etudiant.setResidence(commande.getResidence());
    etudiant.setDescriptionProbleSante(commande.getDescriptionProbleSante());
    etudiant.setContact(commande.getContact());
    etudiant.setOrphelinDeMere(commande.isOrphelinDeMere());
    etudiant.setOrphelinDesDePere(commande.isOrphelinDesDePere());
    etudiant.setOrphelinDesDeuxParent(commande.isOrphelinDesDeuxParent());
    etudiant.setPere(parentPereEtudiant);
    etudiant.setMere(parentMereEtudiant);
    etudiant.setTuteur(tuteurEtudiant);
    this.etudiantRepositoryPort.enregistrer(etudiant);
    return etudiant;
  }

  private ParentPereEtudiant genererParentPere(CreerPereEtudiantCommande commande) {
    var pere = new ParentPereEtudiant();
    pere.setId(UUID.randomUUID());
    pere.setNom(commande.getNom());
    pere.setPrenoms(commande.getPrenoms());
    pere.setContact(commande.getContact());
    pere.setFonction(commande.getFonction());
    pere.setCivilite(commande.getCivilite());
    pere.setNationnailite(commande.getNationnailite());
    pere.setPiece(commande.getPiece());
    pere.setNumeroPiece(commande.getNumeroPiece());
    pere.setResidence(commande.getResidence());
    this.pereEtudiantRepositoryPort.enregistrer(pere);
    return pere;
  }

  private ParentMereEtudiant genererMere(CreerParentMereEtudiantCommande commande) {
    var mere = new ParentMereEtudiant();
    mere.setId(UUID.randomUUID());
    mere.setNom(commande.getNom());
    mere.setPrenoms(commande.getPrenoms());
    mere.setContact(commande.getContact());
    mere.setFonction(commande.getFonction());
    mere.setCivilite(commande.getCivilite());
    mere.setNationnailite(commande.getNationnailite());
    mere.setPiece(commande.getPiece());
    mere.setNumeroPiece(commande.getNumeroPiece());
    mere.setResidence(commande.getResidence());
    this.mereEtudiantRepositoryPort.enregistrer(mere);
    return mere;
  }

  private TuteurEtudiant genererTuteur(CreerTuTeurEtudiantCommande commande) {
    var tuteur = new TuteurEtudiant();
    tuteur.setId(UUID.randomUUID());
    tuteur.setNom(commande.getNom());
    tuteur.setPrenoms(commande.getPrenoms());
    tuteur.setContact(commande.getContact());
    tuteur.setFonction(commande.getFonction());
    tuteur.setCivilite(commande.getCivilite());
    tuteur.setNationnailite(commande.getNationnailite());
    tuteur.setPiece(commande.getPiece());
    tuteur.setNumeroPiece(commande.getNumeroPiece());
    tuteur.setResidence(commande.getResidence());
    this.tuteurRepositoryPort.enregistrer(tuteur);
    return tuteur;
  }
}
