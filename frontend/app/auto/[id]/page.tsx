import Link from 'next/link';
import { notFound } from 'next/navigation';
import { BookingForm } from '@/components/BookingForm';
import { getAutoById } from '@/lib/api';

export default async function AutoDetailPage({ params }: { params: Promise<{ id: string }> }) {
  const { id } = await params;

  let auto;

  try {
    auto = await getAutoById(id);
  } catch {
    notFound();
  }

  return (
    <section className="section page-shell">
      <div className="container detail-layout">
        <div className="card detail-card">
          <span className="eyebrow">Dettaglio auto</span>
          <h1>
            {auto.marca} {auto.modello}
          </h1>
          <p className="lead">
            {auto.anno} · {auto.carburante} · {auto.cambio}
          </p>

          <div className="detail-grid">
            <div>
              <strong>Prezzo giornaliero</strong>
              <p>€ {auto.prezzoGiornaliero.toFixed(2)}</p>
            </div>
            <div>
              <strong>Disponibilità generale</strong>
              <p>{auto.disponibile ? 'Disponibile' : 'Non disponibile'}</p>
            </div>
            <div>
              <strong>ID auto</strong>
              <p>#{auto.id}</p>
            </div>
            <div>
              <strong>Note</strong>
              <p>La disponibilità finale viene verificata sulle date scelte in fase di prenotazione.</p>
            </div>
          </div>

          <Link href="/catalogo" className="btn btn-secondary">
            Torna al catalogo
          </Link>
        </div>

        <BookingForm autoId={auto.id} autoLabel={`${auto.marca} ${auto.modello}`} />
      </div>
    </section>
  );
}
