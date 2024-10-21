# Use Alpine as the base image
FROM alpine:latest

# Install dependencies
RUN apk update && apk add --no-cache \
    podman \
    fuse-overlayfs \
    shadow \
    iptables

# Create a user (Podman needs a user to run as non-root)
RUN useradd -ms /bin/bash podmanuser

# Switch to the new user
USER podmanuser

# Print Podman version to verify installation
CMD ["podman", "--version"]

