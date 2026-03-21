'use client';

import { FormEvent, useMemo, useState } from 'react';
import { createPrenotazione } from '@/lib/api';

type BookingFormProps = {
  autoId: number;
  autoLabel: string;
};

export function BookingForm({ autoId, autoLabel }: BookingFormProps) {
  const today = useMemo(() => new Date().toISOString().split('T')[0], []);

  const [form, setForm] = useState({
    nomeCliente: '',
    cognomeCliente: '',
    emailCliente: '',
    dataInizio: '',
    dataFine: '',
  });
  const [loading, setLoading] = useState(false);
  const [message, setMessage] = useState('');
  const [error, setError] = useState('');

  async function handleSubmit(event: FormEvent<HTMLFormElement>) {
    event.preventDefault();
    setLoading(true);
    setMessage('');
    setError('');

    try {
      await createPrenotazione({
        autoId,
        ...form,
      });

      setMessage(`Prenotazione inviata con successo per ${autoLabel}.`);
      setForm({
        nomeCliente: '',
        cognomeCliente: '',
        emailCliente: '',
        dataInizio: '',
        dataFine: '',
      });
    } catch (err) {
      setError(err instanceof Error ? err.message : 'Errore durante la prenotazione');
    } finally {
      setLoading(false);
    }
  }

  return (
    <div className="card booking-panel">
      <h2>Richiedi prenotazione</h2>
      <p className="muted">Compila i dati per inviare la prenotazione al backend.</p>

      <form className="form-grid" onSubmit={handleSubmit}>
        <label>
          Nome
          <input
            type="text"
            required
            value={form.nomeCliente}
            onChange={(event) => setForm((prev) => ({ ...prev, nomeCliente: event.target.value }))}
          />
        </label>

        <label>
          Cognome
          <input
            type="text"
            required
            value={form.cognomeCliente}
            onChange={(event) => setForm((prev) => ({ ...prev, cognomeCliente: event.target.value }))}
          />
        </label>

        <label className="full-width">
          Email
          <input
            type="email"
            required
            value={form.emailCliente}
            onChange={(event) => setForm((prev) => ({ ...prev, emailCliente: event.target.value }))}
          />
        </label>

        <label>
          Data inizio
          <input
            type="date"
            min={today}
            required
            value={form.dataInizio}
            onChange={(event) => setForm((prev) => ({ ...prev, dataInizio: event.target.value }))}
          />
        </label>

        <label>
          Data fine
          <input
            type="date"
            min={form.dataInizio || today}
            required
            value={form.dataFine}
            onChange={(event) => setForm((prev) => ({ ...prev, dataFine: event.target.value }))}
          />
        </label>

        <button className="btn btn-primary full-width" type="submit" disabled={loading}>
          {loading ? 'Invio in corso...' : 'Invia prenotazione'}
        </button>
      </form>

      {message ? <div className="success-box">{message}</div> : null}
      {error ? <div className="error-box">{error}</div> : null}
    </div>
  );
}
