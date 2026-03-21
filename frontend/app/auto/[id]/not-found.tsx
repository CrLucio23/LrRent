import Link from 'next/link';

export default function NotFound() {
  return (
    <section className="section page-shell">
      <div className="container">
        <div className="card empty-state">
          <h1>Auto non trovata</h1>
          <p>Controlla l&apos;ID oppure torna al catalogo completo.</p>
          <Link href="/catalogo" className="btn btn-primary">
            Vai al catalogo
          </Link>
        </div>
      </div>
    </section>
  );
}
