import Link from 'next/link';
import { Hero } from '@/components/Hero';
import { FeaturedAutos } from '@/components/FeaturedAutos';

export default function HomePage() {
  return (
    <>
      <Hero />
      <FeaturedAutos />

      <section className="section section-alt">
        <div className="container steps-grid">
          <div className="card step-card">
            <span className="step-number">01</span>
            <h3>Consulta il catalogo</h3>
            <p>Esplora le auto, verifica caratteristiche, prezzo giornaliero e disponibilità generale.</p>
          </div>
          <div className="card step-card">
            <span className="step-number">02</span>
            <h3>Controlla le date</h3>
            <p>Usa il filtro disponibilità per mostrare solo le auto libere nel range selezionato.</p>
          </div>
          <div className="card step-card">
            <span className="step-number">03</span>
            <h3>Prenota online</h3>
            <p>Invia la tua richiesta dalla pagina dettaglio dell&apos;auto con un form connesso alle API.</p>
          </div>
        </div>
      </section>

      <section className="section cta-section">
        <div className="container cta-box">
          <div>
            <span className="eyebrow">Progetto portfolio</span>
            <h2>Backend finito. Ora hai anche un frontend completo.</h2>
            <p>Catalogo, dettaglio auto, prenotazione e pagina contatti già pronti.</p>
          </div>
          <Link href="/catalogo" className="btn btn-primary">
            Consulta il catalogo
          </Link>
        </div>
      </section>
    </>
  );
}
