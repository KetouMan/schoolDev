package com.luna.school.inscription.application.casutilisation;

import com.luna.school.classe.application.port.ClasseRepositoryPort;
import com.luna.school.classe.domaine.entite.Classe;
import com.luna.school.comptabilite.domaine.entite.Comptabilite;
import com.luna.school.etudiant.application.port.EtudiantRepositoryPort;
import com.luna.school.etudiant.application.port.MereEtudiantRepositoryPort;
import com.luna.school.etudiant.application.port.PereEtudiantRepositoryPort;
import com.luna.school.etudiant.application.port.TuteurRepositoryPort;
import com.luna.school.etudiant.domaine.entite.Etudiant;
import com.luna.school.etudiant.domaine.entite.ParentMereEtudiant;
import com.luna.school.etudiant.domaine.entite.ParentPereEtudiant;
import com.luna.school.etudiant.domaine.entite.TuteurEtudiant;
import com.luna.school.inscription.application.commande.ModifierInscriptionCommande;
import com.luna.school.inscription.application.port.InscriptionRepositoryPort;
import com.luna.school.inscription.domaine.entite.Inscription;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

/**
 * @author BOUA YVES 2024-04-21
 */
@Service
public class ModifierInscription {

  private final InscriptionRepositoryPort inscriptionRepositoryPort;
  private final PereEtudiantRepositoryPort pereEtudiantRepositoryPort;
  private final MereEtudiantRepositoryPort mereEtudiantRepositoryPort;
  private final TuteurRepositoryPort tuteurRepositoryPort;
  private final EtudiantRepositoryPort etudiantRepositoryPort;
  private final ClasseRepositoryPort classeRepositoryPort;
  private final Logger logger = Logger.getLogger(ModifierInscriptionCommande.class.getName());


  public ModifierInscription(InscriptionRepositoryPort inscriptionRepositoryPort,
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

  public void modifier(ModifierInscriptionCommande commande) {
    Inscription inscription = this.genererInscription(commande);
    this.inscriptionRepositoryPort.enregistrer(inscription);
    logger.info("inscription effectuée avec succès !");
  }





    private Inscription genererInscription(ModifierInscriptionCommande commande) {
    Classe classePrecedente = this.classeRepositoryPort.recupererParId(commande.getClassePrecedanteId());
    Classe classeActuelle = this.classeRepositoryPort.recupererParId(commande.getClasseActuelleId());
      Inscription inscription = this.inscriptionRepositoryPort.recupereParId(commande.getId());
      Etudiant etudiant1 = this.etudiantRepositoryPort.recupererParId(
          inscription.getEtudiant().getId());
      Etudiant etudiant = this.modifierEtudiant(commande,etudiant1.getId());
    BigDecimal montantScolarite = classeActuelle.getNiveau().getMontantScolarite();
    BigDecimal montantVerset = commande.getMontantVerset();
    var comptabilite = new Comptabilite();
    comptabilite.setId(UUID.randomUUID());
    comptabilite.setScolariteTotale(montantScolarite);
    comptabilite.setMontantVerset(montantVerset);
    BigDecimal reste = montantScolarite.subtract(montantVerset);
    comptabilite.setReste(reste);
    comptabilite.setEtudiant(etudiant);
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


  //informationEtudiant
  private Etudiant modifierEtudiant(ModifierInscriptionCommande commande,UUID idEtudiant){
    Etudiant etudiant = this.etudiantRepositoryPort.recupererParId(idEtudiant);
    UUID idMereEtudiant = etudiant.getMere().getId();
    UUID idPereEtudiant = etudiant.getPere().getId();
    UUID idTuteurEtudiant = etudiant.getTuteur().getId();
    ParentMereEtudiant mereEtudiant = this.modifierMere(commande, idMereEtudiant);
    ParentPereEtudiant parentPereEtudiant = this.modifierPere(commande, idPereEtudiant);
    TuteurEtudiant tuteurEtudiant = this.modifierTuteur(commande, idTuteurEtudiant);
    etudiant.setCivilite(commande.getCreerEtudiantCommende().getCivilite());
    etudiant.setStatut(commande.getCreerEtudiantCommende().getStatut());
    etudiant.setBoursier(commande.getCreerEtudiantCommende().isBoursier());
    etudiant.setMatricule(commande.getCreerEtudiantCommende().getMatricule());
    etudiant.setNom(commande.getCreerEtudiantCommende().getNom());
    etudiant.setPrenoms(commande.getCreerEtudiantCommende().getPrenoms());
    etudiant.setDateNaissance(commande.getCreerEtudiantCommende().getDateNaissance());
    etudiant.setLieuNaissance(commande.getCreerEtudiantCommende().getLieuNaissance());
    etudiant.setNationnailite(commande.getCreerEtudiantCommende().getNationnailite());
    etudiant.setResidence(commande.getCreerEtudiantCommende().getResidence());
    etudiant.setDescriptionProbleSante(commande.getCreerEtudiantCommende().getDescriptionProbleSante());
    etudiant.setContact(commande.getCreerEtudiantCommende().getContact());
    etudiant.setOrphelinDeMere(commande.getCreerEtudiantCommende().isOrphelinDeMere());
    etudiant.setOrphelinDesDePere(commande.getCreerEtudiantCommende().isOrphelinDesDePere());
    etudiant.setOrphelinDesDeuxParent(commande.getCreerEtudiantCommende().isOrphelinDesDeuxParent());
    etudiant.setPere(parentPereEtudiant);
    etudiant.setMere(mereEtudiant);
    etudiant.setTuteur(tuteurEtudiant);
    this.etudiantRepositoryPort.enregistrer(etudiant);
    return etudiant;
  }




  //bloc de renseignement des information des parents

  private ParentPereEtudiant modifierPere(ModifierInscriptionCommande commande,UUID idPereEtudiant){
    ParentPereEtudiant parentPereEtudiant = this.pereEtudiantRepositoryPort.recupererParId(idPereEtudiant);
    parentPereEtudiant.setNom(commande.getCreerEtudiantCommende().getParentPereCommande().getNom());
    parentPereEtudiant.setPrenoms(commande.getCreerEtudiantCommende().getParentPereCommande().getPrenoms());
    parentPereEtudiant.setContact(commande.getCreerEtudiantCommende().getParentPereCommande().getContact());
    parentPereEtudiant.setFonction(commande.getCreerEtudiantCommende().getParentPereCommande().getFonction());
    parentPereEtudiant.setCivilite(commande.getCreerEtudiantCommende().getParentPereCommande().getCivilite());
    parentPereEtudiant.setNationnailite(commande.getCreerEtudiantCommende().getParentPereCommande().getNationnailite());
    parentPereEtudiant.setPiece(commande.getCreerEtudiantCommende().getParentPereCommande().getPiece());
    parentPereEtudiant.setNumeroPiece(commande.getCreerEtudiantCommende().getParentPereCommande().getNumeroPiece());
    parentPereEtudiant.setResidence(commande.getCreerEtudiantCommende().getParentPereCommande().getResidence());
    this.pereEtudiantRepositoryPort.enregistrer(parentPereEtudiant);
    return parentPereEtudiant;
  }

  private ParentMereEtudiant modifierMere(ModifierInscriptionCommande commande,UUID idMereEtudiant) {
    ParentMereEtudiant mereEtudiant = this.mereEtudiantRepositoryPort.recupererParId(
        idMereEtudiant);
    mereEtudiant.setNom(commande.getCreerEtudiantCommende().getParentMereCommande().getNom());
    mereEtudiant.setPrenoms(commande.getCreerEtudiantCommende().getParentMereCommande().getPrenoms());
    mereEtudiant.setContact(commande.getCreerEtudiantCommende().getParentMereCommande().getContact());
    mereEtudiant.setFonction(commande.getCreerEtudiantCommende().getParentMereCommande().getFonction());
    mereEtudiant.setCivilite(commande.getCreerEtudiantCommende().getParentMereCommande().getCivilite());
    mereEtudiant.setNationnailite(commande.getCreerEtudiantCommende().getParentMereCommande().getNationnailite());
    mereEtudiant.setPiece(commande.getCreerEtudiantCommende().getParentMereCommande().getPiece());
    mereEtudiant.setNumeroPiece(commande.getCreerEtudiantCommende().getParentMereCommande().getNumeroPiece());
    mereEtudiant.setResidence(commande.getCreerEtudiantCommende().getParentMereCommande().getResidence());
    this.mereEtudiantRepositoryPort.enregistrer(mereEtudiant);
    return mereEtudiant;
  }

  private TuteurEtudiant modifierTuteur(ModifierInscriptionCommande commande,UUID idTuteurEtudiant) {
    TuteurEtudiant tuteurEtudiant = this.tuteurRepositoryPort.recupererParId(
        idTuteurEtudiant);
    tuteurEtudiant.setNom(commande.getCreerEtudiantCommende().getTuTeurEtudiantCommande().getNom());
    tuteurEtudiant.setPrenoms(commande.getCreerEtudiantCommende().getTuTeurEtudiantCommande().getPrenoms());
    tuteurEtudiant.setContact(commande.getCreerEtudiantCommende().getTuTeurEtudiantCommande().getContact());
    tuteurEtudiant.setFonction(commande.getCreerEtudiantCommende().getTuTeurEtudiantCommande().getFonction());
    tuteurEtudiant.setCivilite(commande.getCreerEtudiantCommende().getTuTeurEtudiantCommande().getCivilite());
    tuteurEtudiant.setNationnailite(commande.getCreerEtudiantCommende().getTuTeurEtudiantCommande().getNationnailite());
    tuteurEtudiant.setPiece(commande.getCreerEtudiantCommende().getTuTeurEtudiantCommande().getPiece());
    tuteurEtudiant.setNumeroPiece(commande.getCreerEtudiantCommende().getTuTeurEtudiantCommande().getNumeroPiece());
    tuteurEtudiant.setResidence(commande.getCreerEtudiantCommende().getTuTeurEtudiantCommande().getResidence());
    this.tuteurRepositoryPort.enregistrer(tuteurEtudiant);
    return tuteurEtudiant;
  }



}
