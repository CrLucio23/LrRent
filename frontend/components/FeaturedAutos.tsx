import { getAutoList } from '@/lib/api';
import { AutoCard } from '@/components/AutoCard';

export async function FeaturedAutos() {
  let autos = [];

  try {
    autos = await getAutoList();
  } catch {
    autos = [];
  }

  const featured = autos.slice(0, 3);

  return (
    <section className="section">
      <div className="container">
        <div className="section-heading">
          <div>
            <span className="eyebrow">Catalogo</span>
            <h2>Auto in evidenza</h2>
          </div>
          <p>Le prime auto recuperate dalle API del backend.</p>
        </div>

        {featured.length === 0 ? (
          <div className="card empty-state">
            Nessuna auto disponibile al momento. Inserisci qualche auto dal backend e ricarica la pagina.
          </div>
        ) : (
          <div className="grid cards-grid">
            {featured.map((auto) => (
              <AutoCard key={auto.id} auto={auto} />
            ))}
          </div>
        )}
      </div>
    </section>
  );
}
