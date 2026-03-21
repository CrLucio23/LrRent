import Link from 'next/link';

export function Hero() {
  return (
    <section className="hero">
      <div className="container hero-grid">
        <div>
          <span className="eyebrow">Noleggio auto premium</span>
          <h1>Trova l&apos;auto giusta per il tuo prossimo viaggio.</h1>
          <p>
            Un front-end moderno per consultare il catalogo, verificare la disponibilità per data e inviare
            una prenotazione in pochi secondi.
          </p>
          <div className="hero-actions">
            <Link href="/catalogo" className="btn btn-primary">
              Vai al catalogo
            </Link>
            <Link href="/contatti" className="btn btn-secondary">
              Contattaci
            </Link>
          </div>
        </div>

        <div className="hero-card">
          <div className="hero-stat">
            <strong>100%</strong>
            <span>Connesso al tuo backend Spring Boot</span>
          </div>
          <div className="hero-stat">
            <strong>Ricerca</strong>
            <span>Disponibilità reale per intervallo date</span>
          </div>
          <div className="hero-stat">
            <strong>Prenota</strong>
            <span>Richiesta integrata con il modulo prenotazioni</span>
          </div>
        </div>
      </div>
    </section>
  );
}
