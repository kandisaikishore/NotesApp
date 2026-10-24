# Scalability baseline

## Priorities
- Establish current stack, data flows, external dependencies, and bottlenecks before introducing infrastructure.
- Keep service instances stateless where practical; externalize shared state before adding replicas.
- Bound request sizes, concurrency, connection pools, retries, and queue depth to prevent overload.
- Paginate large list endpoints and index measured database access paths after reviewing query plans.
- Add request correlation IDs, structured logs, health checks, timeouts, and explicit degraded-service behavior.
- Keep secrets in deployment configuration, not source control; separate development and production settings.
- Add automated build, unit, integration, security/dependency, and deployment smoke checks appropriate to the stack.

## Load validation
Test normal, peak, and burst traffic using realistic test data. Record throughput, p95/p99 latency, error rate, CPU/memory, database wait time, queue lag, and cost where relevant. Scale only after profiling identifies the limiting resource.

## Deployment gates
- [ ] Runtime and deployment assumptions are documented.
- [ ] Health/readiness checks and graceful shutdown are validated where services exist.
- [ ] Retry behavior is bounded and idempotent for state-changing workflows.
- [ ] Backup/restore and rollback are documented for persistent data.
- [ ] Capacity assumptions and real load-test results are recorded.

This document is a planning checklist, not evidence that load tests or production scaling have been completed.