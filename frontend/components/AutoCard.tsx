import Link from 'next/link';
import { Auto } from '@/lib/types';

export function AutoCard({ auto }: { auto: Auto }) {
  return (
    <article className="card auto-card">
      <div className="auto-card__badge">{auto.disponibile ? 'Disponibile' : 'Non disponibile'}</div>
      <h3>
        {auto.marca} {auto.modello}
      </h3>
      <p className="muted">
        {auto.anno} · {auto.carburante} · {auto.cambio}
      </p>
      <div className="auto-card__price">€ {auto.prezzoGiornaliero.toFixed(2)} / giorno</div>
      <div className="auto-card__actions">
        <Link className="btn btn-primary" href={`/auto/${auto.id}`}>
          Dettaglio
        </Link>
      </div>
    </article>
  );
}
