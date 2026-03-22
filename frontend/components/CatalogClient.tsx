'use client';

import { FormEvent, useEffect, useState } from 'react';
import { AutoCard } from '@/components/AutoCard';
import { getAutoList, getAvailableAuto, getFilteredAuto } from '@/lib/api';
import { Auto } from '@/lib/types';

const initialFilters = {
  disponibile: 'all',
  carburante: '',
  dataInizio: '',
  dataFine: '',
};

export function CatalogClient() {
  const [autos, setAutos] = useState<Auto[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');
  const [filters, setFilters] = useState(initialFilters);

  useEffect(() => {
    loadAllAutos();
  }, []);

  async function loadAllAutos() {
    try {
      setLoading(true);
      setError('');
      const data = await getAutoList();
      setAutos(data);
    } catch (err) {
      setError(err instanceof Error ? err.message : 'Errore caricamento auto');
    } finally {
      setLoading(false);
    }
  }

  async function handleFilters(event: FormEvent<HTMLFormElement>) {
    event.preventDefault();
    setLoading(true);
    setError('');

    try {
      if (filters.dataInizio && filters.dataFine) {
        const data = await getAvailableAuto(filters.dataInizio, filters.dataFine);
        setAutos(data);
        return;
      }

      const data = await getFilteredAuto({
        disponibile: filters.disponibile === 'all' ? undefined : filters.disponibile === 'true',
        carburante: filters.carburante || undefined,
      });

      setAutos(data);
    } catch (err) {
      setError(err instanceof Error ? err.message : 'Errore durante il filtraggio');
    } finally {
      setLoading(false);
    }
  }

  function resetFilters() {
    setFilters(initialFilters);
    loadAllAutos();
  }

  return (
    <div className="catalog-layout">
      <aside className="card filters-panel">
        <h2>Filtri</h2>
        <form onSubmit={handleFilters} className="form-stack">
          <label>
            Disponibilità
            <select
              value={filters.disponibile}
              onChange={(event) => setFilters((prev) => ({ ...prev, disponibile: event.target.value }))}
            >
              <option value="all">Tutte</option>
              <option value="true">Disponibili</option>
              <option value="false">Non disponibili</option>
            </select>
          </label>

      <label>
        Carburante
        <select
          value={filters.carburante}
          onChange={(event) => setFilters((prev) => ({ ...prev, carburante: event.target.value }))}
        >
          <option value="">Tutti</option>
          <option value="Benzina">Benzina</option>
          <option value="Diesel">Diesel</option>
          <option value="Elettrico">Elettrico</option>
          <option value="Hybrid">Hybrid</option>
        </select>
      </label>

          <div className="divider" />

          <label>
            Data inizio
            <input
              type="date"
              value={filters.dataInizio}
              onChange={(event) => setFilters((prev) => ({ ...prev, dataInizio: event.target.value }))}
            />
          </label>

          <label>
            Data fine
            <input
              type="date"
              value={filters.dataFine}
              onChange={(event) => setFilters((prev) => ({ ...prev, dataFine: event.target.value }))}
            />
          </label>

          <button className="btn btn-primary" type="submit">
            Applica filtri
          </button>
          <button className="btn btn-secondary" type="button" onClick={resetFilters}>
            Reset
          </button>
        </form>
      </aside>

      <section>
        <div className="section-heading section-heading--small">
          <div>
            <span className="eyebrow">Catalogo completo</span>
            <h1>Le nostre auto</h1>
          </div>
          <p>{loading ? 'Caricamento...' : `${autos.length} risultati trovati`}</p>
        </div>

        {error ? <div className="card error-box">{error}</div> : null}

        {loading ? (
          <div className="card empty-state">Caricamento auto in corso...</div>
        ) : autos.length === 0 ? (
          <div className="card empty-state">Nessuna auto trovata con i criteri selezionati.</div>
        ) : (
          <div className="grid cards-grid">
            {autos.map((auto) => (
              <AutoCard key={auto.id} auto={auto} />
            ))}
          </div>
        )}
      </section>
    </div>
  );
}
